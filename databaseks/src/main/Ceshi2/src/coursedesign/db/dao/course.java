package coursedesign.db.dao;

public class course {
    private String course_id;
    private String course_name;
    private int course_xueshi;
    private int course_renshu;
    private String course_duixiang;
    private String course_xingzhi;
    private String course_time;
    private String student_id;
    private String teacher_id;

    public String getcourse_id() {
        return course_id;
    }

    public void setcourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getcourse_name() {
        return course_name;
    }

    public void setcourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getcourse_xueshi() {
        return course_xueshi;
    }

    public void setcourse_xueshi(int course_xueshi) {
        this.course_xueshi = course_xueshi;
    }

    public int getcourse_renshu() {
        return course_renshu;
    }

    public void setcourse_renshu(int course_renshu) {
        this.course_renshu = course_renshu;
    }

    public String getcourse_duixiang() {
        return course_duixiang;
    }

    public void setcourse_duixiang(String course_duixiang) {
        this.course_duixiang = course_duixiang;
    }

    public String getcourse_xingzhi() {
        return course_xingzhi;
    }

    public void setcourse_xingzhi(String course_xingzhi) {
        this.course_xingzhi = course_xingzhi;
    }

    public String getcourse_time() {
        return course_time;
    }

    public void setcourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getstudent_id() {
        return student_id;
    }

    public void setstudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getteacher_id() {
        return teacher_id;
    }

    public void setteacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}
