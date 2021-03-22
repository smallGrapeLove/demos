package optional.entity1;

/**
 * 分数
 *
 * @author huan.xu
 * @Date 2020-11-20
 */
public class Grade {

    /**
     * 学科
     */
    private String type;
    /**
     * 得分
     */
    private Integer score;

    public Grade(String type, Integer score) {
        this.type = type;
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
