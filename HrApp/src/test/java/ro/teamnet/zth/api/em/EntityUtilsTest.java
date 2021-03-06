package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.appl.domain.Department;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);

        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumnsMethod() {
        List<ColumnInfo> columns = EntityUtils.getColumns(Department.class, false);

        assertEquals(3, columns.size());
    }

    @Test
    public void testGetFieldsByAnnotations() throws NoSuchFieldException {
        List<Field> fields = new ArrayList<>();
        Class aClass = Department.class;
        Field field = aClass.getDeclaredField("departmentName");
        Field field1 = aClass.getDeclaredField("locations");
        fields.add(field);
        fields.add(field1);

        assertEquals(fields.size(), EntityUtils.getFieldsByAnnotations(Department.class, Column.class).size());
    }

}
