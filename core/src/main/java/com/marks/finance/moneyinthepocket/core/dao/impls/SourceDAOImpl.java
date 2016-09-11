package com.marks.finance.moneyinthepocket.core.dao.impls;


import com.marks.finance.moneyinthepocket.core.dao.interfaces.SourceDAO;
import com.marks.finance.moneyinthepocket.core.database.SQLiteConnection;
import com.marks.finance.moneyinthepocket.core.enums.OperationType;
import com.marks.finance.moneyinthepocket.core.impls.DefaultSource;
import com.marks.finance.moneyinthepocket.core.interfaces.Source;
import com.marks.finance.moneyinthepocket.core.utils.TreeConstructor;


/**
 * Created by Alexander on 9/11/2016.
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class SourceDAOImpl implements SourceDAO {

    private static final String SOURCE_TABLE = "source";

    private List<Source> sourceList = new ArrayList<>();
    private Map<OperationType, List<Source>> sourceMap = new EnumMap<>(OperationType.class);

    private TreeConstructor<Source> treeConstructor = new TreeConstructor();


    @Override
    public List<Source> getAll() {
        sourceList.clear();

        try (Statement stmt = SQLiteConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("select * from " + SOURCE_TABLE);) {

            while (rs.next()) {
                DefaultSource source = new DefaultSource();
                source.setId(rs.getLong("id"));
                source.setName(rs.getString("name"));

                Integer operationTypeId = rs.getInt("operation_type_id");

                OperationType operationType = OperationType.getType(operationTypeId);
                source.setOperationType(operationType);

                Long parentId = rs.getLong("parent_id");

                sourceMap.put(operationType, sourceList);

                treeConstructor.addToTree(parentId, source, sourceList);

            }

            fillSourceMap();

            return sourceList;

        } catch (SQLException e) {
            Logger.getLogger(SourceDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }


    private void fillSourceMap() {

        for (OperationType type: OperationType.values()) {

            sourceMap.put(type, sourceList.stream().filter(s -> s.getOperationType() == type).collect(Collectors.toList()));
        }

    }

    @Override
    public Source get(long id) {
        return null;
    }

    @Override
    public boolean update(Source source) {

        try (PreparedStatement stmt = SQLiteConnection.getConnection().prepareStatement("update " + SOURCE_TABLE + " set name=? where id=?");) {

            stmt.setString(1, source.getName());
            stmt.setLong(2, source.getId());



            if (stmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            Logger.getLogger(SourceDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    @Override
    public boolean delete(Source source) {

        try (PreparedStatement stmt = SQLiteConnection.getConnection().prepareStatement("delete from " + SOURCE_TABLE + " where id=?");) {

            stmt.setLong(1, source.getId());

            if (stmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            Logger.getLogger(SourceDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    @Override
    public List<Source> getList(OperationType operationType) {
        return sourceMap.get(operationType);
    }
}
