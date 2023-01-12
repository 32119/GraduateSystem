package coursedesign.db.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String id="";
    public static void main(String[] args) {
        System.out.println("欢迎登录研究生助教工作子系统！请选择身份：1.研究生培养管理员2.学科负责人3.授课老师4.导师5.研究生");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.print("请输入账号：");
        id=scanner.nextLine();
        if(s.equals("1")){ //研究生培养管理员
            while(true){
                System.out.println("选择功能：1.创建课程 2.查看所有课程 3.删除课程 4.修改课程信息 5.更新志愿结果 6.退出");
                String s1=scanner.nextLine();
                if(s1.equals("1")){
                    course c=new course();
                    System.out.print("请输入课程id:");
                    String s2=scanner.nextLine();
                    c.setcourse_id(s2);
                    System.out.print("请输入课程名称:");
                    String s3=scanner.nextLine();
                    c.setcourse_name(s3);
                    System.out.print("请输入学时:");
                    Integer s4=scanner.nextInt();
                    c.setcourse_xueshi(s4);
                    System.out.print("请输入课程人数:");
                    Integer s5=scanner.nextInt();
                    String ss=scanner.nextLine();
                    c.setcourse_renshu(s5);
                    System.out.print("请输入授课对象（本科生/研究生）:");
                    String s6=scanner.nextLine();
                    c.setcourse_duixiang(s6);
                    System.out.print("请输入课程性质（必修课/选修课）:");
                    String s7=scanner.nextLine();
                    c.setcourse_xingzhi(s7);
                    System.out.print("请输入课程时间:");
                    String s8=scanner.nextLine();
                    c.setcourse_time(s8);
                    chuangjiankecheng(c);
                    System.out.println("创建成功。");
                }else if(s1.equals("2")){
                    List<course> list=new ArrayList<course>();
                    list=DAOFactory.getInstance().getCourseDAO().getCourse();
                    for(course c:list){
                        System.out.println(c.getcourse_id()+" "+c.getcourse_name()+" "+c.getcourse_xueshi()+" "
                        +c.getcourse_renshu()+" "+c.getcourse_duixiang()+c.getcourse_xingzhi()+" "
                        +c.getcourse_time()+" "+c.getstudent_id()+" "+c.getteacher_id());
                    }
                }else if(s1.equals("3")){
                    List<course> list=new ArrayList<course>();
                    list=DAOFactory.getInstance().getCourseDAO().getCourse();
                    for(course c:list){
                        System.out.println(c.getcourse_id()+" "+c.getcourse_name()+" "+c.getcourse_xueshi()+" "
                                +c.getcourse_renshu()+" "+c.getcourse_duixiang()+c.getcourse_xingzhi()+" "
                                +c.getcourse_time()+" "+c.getstudent_id()+" "+c.getteacher_id());
                    }
                    System.out.println("请输入要删除的课程id：");
                    String s2=scanner.nextLine();
                    DAOFactory.getInstance().getCourseDAO().deleteCourse(s2);
                    System.out.println("删除成功。");
                }else if(s1.equals("4")){
                    List<course> list=new ArrayList<course>();
                    list=DAOFactory.getInstance().getCourseDAO().getCourse();
                    for(course c:list){
                        System.out.println(c.getcourse_id()+" "+c.getcourse_name()+" "+c.getcourse_xueshi()+" "
                                +c.getcourse_renshu()+" "+c.getcourse_duixiang()+c.getcourse_xingzhi()+" "
                                +c.getcourse_time()+" "+c.getstudent_id()+" "+c.getteacher_id());
                    }
                    course c=new course();
                    System.out.println("请输入要修改的课程id：");
                    String s2=scanner.nextLine();
                    c.setcourse_id(s2);
                    System.out.println("请输入课程名称：");
                    String s3=scanner.nextLine();
                    c.setcourse_name(s3);
                    System.out.println("请输入课程学时：");
                    Integer s4=scanner.nextInt();
                    String ss=scanner.nextLine();
                    c.setcourse_xueshi(s4);
                    System.out.println("请输入课程人数：");
                    Integer s5=scanner.nextInt();
                    String sss=scanner.nextLine();
                    c.setcourse_renshu(s5);
                    System.out.println("请输入课程对象：");
                    String s6=scanner.nextLine();
                    c.setcourse_duixiang(s6);
                    System.out.println("请输入课程性质：");
                    String s7=scanner.nextLine();
                    c.setcourse_xingzhi(s7);
                    System.out.println("请输入课程时间：");
                    String s8=scanner.nextLine();
                    c.setcourse_time(s8);
                    DAOFactory.getInstance().getCourseDAO().updateCourse(c);
                    System.out.println("更新成功。");

                }else if(s1.equals("5")){
                    List<shenbao> list=new ArrayList<shenbao>();
                    list=DAOFactory.getInstance().getShenbaoDAO().getShenbao();
                    for(shenbao sb:list){
                        System.out.println(sb.getshenbao_id()+" "+sb.getstudent_id()+" "+sb.getzhiyuan1_id()+" "
                                +sb.getzhiyuan2_id()+" "+sb.getzhiyuan1_jieguo()+" "+sb.getzhiyuan2_jieguo());
                    }
                    shenbao sb=new shenbao();
                    System.out.println("请输入要更新的申报id：");
                    String s2=scanner.nextLine();
                    sb.setshenbao_id(s2);
                    System.out.println("请输入要更新的志愿1结果（选中/未选中）：");
                    String s3=scanner.nextLine();
                    sb.setzhiyuan1_jieguo(s3);
                    System.out.println("请输入要更新的志愿2结果（选中/未选中）：");
                    String s4=scanner.nextLine();
                    sb.setzhiyuan2_jieguo(s4);
                    DAOFactory.getInstance().getShenbaoDAO().updateShenbaoJieguo1(sb);
                    DAOFactory.getInstance().getShenbaoDAO().updateShenbaoJieguo2(sb);
                    System.out.println("更新志愿选中结果成功。");
                }else if(s1.equals("6")){
                    break;
                }else {
                    System.out.println("输入错误，请重新输入");
                }
            }
        }else if(s.equals("2")){ //学科负责人
            while(true){
                System.out.println("选择功能：1.维护各自学科有关助教课程优先级、助教可选志愿数量 2.查看当前课程 3.查看评定情况 4.查看申报情况 5.退出");
                String s1=scanner.nextLine();
                if(s1.equals("1")){
                    System.out.print("请选择助教可选志愿数量(1/2)：");
                    String s2=scanner.nextLine();
                    if(s2.equals("1")){
                        DAOFactory.getInstance().getShenbaoDAO().updateZhiyuanShuliang();
                        System.out.println("更新成功。");
                    }else{
                        System.out.println("更新成功。");
                    }
                }else if(s1.equals("2")){
                    List<course> list=new ArrayList<course>();
                    list=DAOFactory.getInstance().getCourseDAO().getCourse();
                    for(course c:list){
                        System.out.println(c.getcourse_id()+" "+c.getcourse_name()+" "+c.getcourse_xueshi()+" "
                                +c.getcourse_renshu()+" "+c.getcourse_duixiang()+c.getcourse_xingzhi()+" "
                                +c.getcourse_time()+" "+c.getstudent_id()+" "+c.getteacher_id());
                    }
                }else if(s1.equals("3")){
                    List<pingding> list=new ArrayList<pingding>();
                    list=DAOFactory.getInstance().getPingdingDAO().getPingding();
                    for(pingding p:list){
                        System.out.println(p.getpingding_id()+" "+p.getcourse_id()+" "+p.getstudent_id()+" "
                                +p.getzishu()+" "+p.getlaoshipingjia()+" "+p.getpingjiajieguo());
                    }
                }else if(s1.equals("4")){
                    List<shenbao> list=new ArrayList<shenbao>();
                    list=DAOFactory.getInstance().getShenbaoDAO().getShenbao();
                    for(shenbao sb:list){
                        System.out.println(sb.getshenbao_id()+" "+sb.getstudent_id()+" "+sb.getzhiyuan1_id()+" "
                                +sb.getzhiyuan2_id()+" "+sb.getzhiyuan1_jieguo()+" "+sb.getzhiyuan2_jieguo());
                    }
                }else if(s1.equals("5")){
                    break;
                }else {
                    System.out.println("输入错误，请重新输入");
                }
            }
        }else if(s.equals("3")){ //授课老师
            while(true){
                System.out.println("选择功能：1.选择课程 2.助教工作评定 3.退出");
                String s1=scanner.nextLine();
                if(s1.equals("1")){
                    xuanzekecheng();
                }else if(s1.equals("2")){
                    gongzuopingding();
                }else if(s1.equals("3")){
                    break;
                }else {
                    System.out.println("输入错误，请重新输入");
                }
            }
        }else if(s.equals("4")){  //导师
            while(true){
                System.out.println("选择功能：1.选择课程 2.取消选择课程 3.助教工作评定 4.退出");
                String s1=scanner.nextLine();
                if(s1.equals("1")){
                    xuanzekecheng();
                }else if(s1.equals("2")){
                    quxiaoxuanzekecheng();
                }else if(s1.equals("3")){
                    gongzuopingding();
                }else if(s1.equals("4")){
                    break;
                }else {
                    System.out.println("输入错误，请重新输入");
                }
            }
        }else if(s.equals("5")){  //研究生
            while(true){
                System.out.println("选择功能：1.申报课程 2.查看选课结果 3.自我评定 4.退出");
                String s1=scanner.nextLine();
                if(s1.equals("1")){
                    shenbaokecheng();
                }else if(s1.equals("2")){
                    chakanxuankejieguo();
                }else if(s1.equals("3")){
                    ziwopingding();
                }else if(s1.equals("4")){
                    break;
                }else {
                    System.out.println("输入错误，请重新输入");
                }
            }
        }

    }

    //教师取消选择课程
    private static void quxiaoxuanzekecheng() {
        List<course> list=new ArrayList<course>();
        list=DAOFactory.getInstance().getCourseDAO().getCourse();
        for(course c1:list){
            System.out.println(c1.getcourse_id()+" "+c1.getcourse_name()+" "+c1.getcourse_xueshi()+" "+
                    c1.getcourse_renshu()+" "+c1.getcourse_duixiang()+" "+c1.getcourse_xingzhi()+" "+
                    c1.getcourse_time()+" "+c1.getstudent_id()+" "+c1.getteacher_id());
        }
        System.out.print("请选择取消授课的课程id：");
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        DAOFactory.getInstance().getChooseDAO().deleteCourse(s1);
        System.out.println("取消授课成功。");
    }

    private static void ziwopingding() {
        List<pingding> list=new ArrayList<pingding>();
        list=DAOFactory.getInstance().getPingdingDAO().getPingding();
        for(pingding p:list){
            System.out.println(p.getpingding_id()+" "+p.getcourse_id()+" "+p.getstudent_id()+" "
            +p.getzishu()+" "+p.getlaoshipingjia()+" "+p.getpingjiajieguo());
        }
        pingding p=new pingding();
        System.out.println("请输入自我评价：");
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        p.setstudent_id(id);
        p.setzishu(s1);
        DAOFactory.getInstance().getPingdingDAO().pingdingStudent(p);
        System.out.println("自我评价成功。");
    }


    private static void gongzuopingding() {
        pingding p=new pingding();
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入需要评价的学生学号：");
        String s1=scanner.nextLine();
        p.setstudent_id(s1);
        System.out.print("请输入你的评价：");
        String s2=scanner.nextLine();
        p.setlaoshipingjia(s2);
        System.out.print("请输入评价结果（合格/不合格）：");
        String s3=scanner.nextLine();
        p.setpingjiajieguo(s3);
        DAOFactory.getInstance().getPingdingDAO().pingdingTeacher(p);
        System.out.println("评价成功。");
    }

    private static void xuanzekecheng() {
        List<course> list=new ArrayList<course>();
        list=DAOFactory.getInstance().getCourseDAO().getCourse();
        for(course c1:list){
            System.out.println(c1.getcourse_id()+" "+c1.getcourse_name()+" "+c1.getcourse_xueshi()+" "+
                    c1.getcourse_renshu()+" "+c1.getcourse_duixiang()+" "+c1.getcourse_xingzhi()+" "+
                    c1.getcourse_time()+" "+c1.getstudent_id()+" "+c1.getteacher_id());
        }
        System.out.print("请选择授课课程id：");
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        course c=new course();
        c.setteacher_id(id);
        DAOFactory.getInstance().getChooseDAO().chooseCourse(c);
        System.out.println("选择授课成功。");
    }

    private static void chuangjiankecheng(course c) {
        DAOFactory.getInstance().getCourseDAO().addCourse(c);
    }

    private static void chakanxuankejieguo() {
        shenbao sb=DAOFactory.getInstance().getShenbaoDAO().getShenbaoById(id);
        System.out.println(sb.getshenbao_id()+" "+sb.getstudent_id()+" "+sb.getzhiyuan1_id()+" "+
                sb.getzhiyuan1_jieguo()+" "+sb.getzhiyuan2_id()+" "+sb.getzhiyuan2_jieguo());
    }

    private static void shenbaokecheng() {
        List<course> list=new ArrayList<course>();
        list=DAOFactory.getInstance().getCourseDAO().getCourse();
        for(course c1:list){
            System.out.println(c1.getcourse_id()+" "+c1.getcourse_name()+" "+c1.getcourse_xueshi()+" "+
                    c1.getcourse_renshu()+" "+c1.getcourse_duixiang()+" "+c1.getcourse_xingzhi()+" "+
                    c1.getcourse_time()+" "+c1.getstudent_id()+" "+c1.getteacher_id());
        }
        System.out.println("请选择需要申报的志愿1和志愿2：");
        System.out.print("志愿1：");
        Scanner scanner=new Scanner(System.in);
        String s2=scanner.nextLine();
        shenbao sb1=new shenbao();
        sb1.setzhiyuan1_id(s2);
        sb1.setstudent_id(id);
        DAOFactory.getInstance().getShenbaoDAO().updateShenbao1(sb1);
        System.out.print("志愿2：");
        String s3=scanner.nextLine();
        shenbao sb2=new shenbao();
        sb2.setzhiyuan2_id(s3);
        sb2.setstudent_id(id);
        DAOFactory.getInstance().getShenbaoDAO().updateShenbao2(sb2);
        System.out.println("志愿1和志愿2申报成功。");
    }


}
