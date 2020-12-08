package cn.keking.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * <p>Title: CommentGenerator</p>
 * <p>Description: mybatis-generator自定义注释类</p>
 * <p>Company: http://www.wootion.com/</p>
 * <p>create date: 2020/03/25</p>
 *
 * @author :tanhuan
 * @version :1.0
 */
public class CommentGenerator extends DefaultCommentGenerator {


    /**
     * 表注释
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)  {
        super.addModelClassComment(topLevelClass, introspectedTable);
        if (introspectedTable.getRemarks() != null && !introspectedTable.getRemarks().equals("")) {
            topLevelClass.addJavaDocLine("/**");
            topLevelClass.addJavaDocLine(" * " + introspectedTable.getRemarks());
            topLevelClass.addJavaDocLine(" */");
        }
    }

    /**
     * 字段注释
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        super.addFieldComment(field, introspectedTable, introspectedColumn);
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            field.addJavaDocLine(" */");
        }
    }
}
