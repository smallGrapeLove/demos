package optional;

import com.alibaba.fastjson.JSONObject;
import optional.entity1.Grade;
import optional.entity1.Student;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * java8 of optional
 * @author huan.xu
 * @Date 2020-11-20
 */
public class Demo1 {

    /**
     * 创建空的Optional对象
     */
    @Test
    public void testEmpty(){
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());
    }

    /**
     * 测试Optional.of和Optional.ofNullable
     */
    @Test
    public void testOf(){
        String name=null;
        //如果name为空Optional.of会java.lang.NullPointerException，而Optional.ofNullable则不会
        //Optional.of(name);
        Optional.ofNullable(name);
    }

    /**
     * 测试 isPresent，如果nameOptional为空，则isPresent=false,否则为true
     */
    @Test
    public void testIsPresent(){
        String name="1";
        Optional<String> nameOptional = Optional.ofNullable(name);
        System.out.println(nameOptional.isPresent());
    }

    /**
     * 测试 ifPresent，ifPresent不为空才执行后面的内容，为空才不执行
     */
    @Test
    public void testIfPresent(){
        String name="2";
        Optional<String> nameOptional = Optional.ofNullable(name);
        nameOptional.ifPresent(n->{
            System.out.println("不为空才执行这里的内容"+n);
        });
        System.out.println(name);
    }

    /**
     * 测试 orElse；如果name为空，则返回orElse里面的默认值或者方法，如果name不为空，直接返回name，但是也会执行orElse里面的方法
     */
    @Test
    public void testOrElse(){
        String name="1";
        String defaultName = Optional.ofNullable(name).orElse(getDefaultValue());
        System.out.println(defaultName);
    }

    /**
     * 测试 orElseGet；和orElse类似，区别在于，如果name为空，不执行orElseGet里面的默认值方法
     */
    @Test
    public void testOrElseGet(){
        String name=null;
        String defaultName = Optional.ofNullable(name).orElseGet(this::getDefaultValue);
        System.out.println(defaultName);

        System.out.println("------------");
        Grade grade=null;
        Grade defaultGrade = Optional.ofNullable(grade).orElseGet(() -> new Grade("语文",90));
        System.out.println(defaultGrade);
    }

    /**
     * 测试orElseThrow，如果grade为空，抛出IllegalArgumentException异常，而不是每次都抛出NullPointerException
     */
    @Test
    public void testOrElseThrow(){
        Grade grade=null;
        Optional.ofNullable(grade).orElseThrow(()->{
            System.out.println("这里抛出异常");
            return new IllegalArgumentException();
        });
    }

    /**
     * 测试map，获取grade中type的值，包装在Optional中
     */
    @Test
    public void testMap(){
        Grade grade=null;
        String defaultType = Optional.ofNullable(grade)
                .map(Grade::getType)
                .orElseGet(this::getDefaultValue);
        System.out.println(defaultType);
    }

    /**
     * 测试 flatMap，获取grade中type的值，包装在Optional中
     */
    @Test
    public void testFlatMap(){
        Grade grade=null;
        String defaultType = Optional.ofNullable(grade)
                .flatMap(g -> Optional.ofNullable(g.getType())).orElseGet(this::getDefaultValue);
        System.out.println(defaultType);
    }

    /**
     * 测试filter，判断grade.score是否大于90
     */
    @Test
    public void testFilter() {
        Grade grade = new Grade("语文", 100);
        boolean flag = Optional.ofNullable(grade).filter(g -> {
            return g.getScore() > 90;
        }).isPresent();
        System.out.println(flag);
    }


    /**
     * 测试Optional打印json
     */
    @Test
    public void testJson() {
        List<Grade> gradeList = new ArrayList<>();
        gradeList.add(new Grade("语文", 100));
        gradeList.add(new Grade("数学", 100));
        gradeList.add(new Grade("英语", 100));
        Student student = new Student("1", "", 12, gradeList);
        Optional.ofNullable(student).ifPresent(s -> {
            System.out.println(JSONObject.toJSONString(s));
        });
    }

    /**
     * 获取默认值
     * @return
     */
    public String getDefaultValue(){
        System.out.println("getDefaultValue method");
        return "default";
    }
}
