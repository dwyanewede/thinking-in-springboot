package think.in.spring.boot.model;

/**
 * @ClassName: Course
 * @Description: 课程实体
 * @Author: 尚先生
 * @CreateDate: 2019/5/22 17:22
 * @Version: 1.0
 */
public class Course {

    private String courseName;
    private String stuName;
    private double score;
    private String currentThreadName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCurrentThreadName() {
        return currentThreadName;
    }

    public void setCurrentThreadName(String currentThreadName) {
        this.currentThreadName = currentThreadName;
    }

    @Override
    public String toString() {
        return "Course实体内容{" +
                "courseName='" + courseName + '\'' +
                ", stuName='" + stuName + '\'' +
                ", currentThreadName='" + currentThreadName + '\'' +
                ", score=" + score +
                '}';
    }
}
