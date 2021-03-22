package optional.entity1;

import java.util.List;

/**
 * 学生
 *
 * @author huan.xu
 * @Date 2020-11-20
 */
public class Student {

    /**
     * 编号
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 名称
     */
    private Integer age;

    /**
     * 成绩
     */
    private List<Grade> gradeList;

    public Student(String id, String name, Integer age, List<Grade> gradeList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gradeList = gradeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}
