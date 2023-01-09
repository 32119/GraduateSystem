package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.DAOFactory;
import Dao.baogao;
import Dao.biaozhun;
import Dao.jiaocai;
import Dao.lunwen;
import Dao.pingtai;
import Dao.zhuanli;

public class Main {

	
	private static void getAlllunwens() {
		List<lunwen> lunwens = new ArrayList<lunwen>();
        lunwens = DAOFactory.getInstance().getlunwenDao(). selectAlllunwen();
        //System.out.println("学号\t姓名\t性别\t班级\t出生日期\t\t电话号码\t\t");
        for (lunwen lunwen : lunwens) {
			System.out.println( lunwen.getStudent_id() + "\t" + 
					lunwen.getLunwenmingcheng() + "\t" + 
					lunwen.getKanwumingcheng() + "\t" + 
					lunwen.getLunwenzhuangtai() + "\t" + 
					lunwen.getFabiaoshijian() + "\t" + 
					lunwen.getSuoyinleixing() + "\t" + 
					lunwen.getGuishukuqingkuang() + "\t");
        }
	}
	private static void addlunwen(  String student_id,
    String  lunwenmingcheng,
    String kanwumingcheng,
    String lunwenzhuangtai,
    String fabiaoshijian,
  String  suoyinleixing,
  String guishukuqingkuang) {
		lunwen lunwen  = new lunwen ();
		  lunwen.setStudent_id(student_id);
          lunwen.setLunwenmingcheng(lunwenmingcheng);
          lunwen.setKanwumingcheng(kanwumingcheng);
          lunwen.setLunwenzhuangtai(lunwenzhuangtai);
          lunwen.setFabiaoshijian(fabiaoshijian);
          lunwen.setSuoyinleixing(suoyinleixing);
          lunwen.setGuishukuqingkuang(guishukuqingkuang);
        DAOFactory.getInstance().getlunwenDao().addlunwen(lunwen);
	}
	
	private static void updatelunwen( String student_id,String shuxing,String value) {	
		//修改前
		System.out.println("改前");
		getlunwen(student_id);
		lunwen lunwen = DAOFactory.getInstance().getlunwenDao().getlunwen(student_id);
		
		if(shuxing.equals("lunwenmingcheng"))
		lunwen.setLunwenmingcheng(value);
		
		if(shuxing.equals("kanwumingcheng"))
			lunwen.setKanwumingcheng(value);
		
		if(shuxing.equals("lunwenzhuangtai"))
			lunwen.setLunwenzhuangtai(value);
		
		if(shuxing.equals("fabiaoshijian"))
			lunwen.setFabiaoshijian(value);
		
		if(shuxing.equals("suoyinleixing"))
			lunwen.setSuoyinleixing(value);
		
		if(shuxing.equals("guishukuqingkuang"))
			lunwen.setGuishukuqingkuang(value);
		DAOFactory.getInstance().getlunwenDao().updatelunwen(lunwen);
		//修改后
		System.out.println("改后");
		getlunwen(student_id);
	}
	private static void getlunwen(String student_id) {	//获取数据库中学号为0510的学生信息
		lunwen lunwen = DAOFactory.getInstance().getlunwenDao().getlunwen(student_id);
		
		System.out.println( lunwen.getStudent_id() + "\t" + 
				lunwen.getLunwenmingcheng() + "\t" + 
				lunwen.getKanwumingcheng() + "\t" + 
				lunwen.getLunwenzhuangtai() + "\t" + 
				lunwen.getFabiaoshijian() + "\t" + 
				lunwen.getSuoyinleixing() + "\t" + 
				lunwen.getGuishukuqingkuang() + "\t");
	}
	
	private static void deletelunwen(String student_id) {	//删除数据库中学号为0510的学生信息
		DAOFactory.getInstance().getlunwenDao().deletelunwen(student_id);
	}
	
	
	
	/////////////////////
	////////////////
	//////////////教材
	
	private static void getAlljiaocais() {
		List<jiaocai> jiaocais = new ArrayList<jiaocai>();
        jiaocais = DAOFactory.getInstance().getjiaocaiDao(). selectAlljiaocai();
        //System.out.println("学号\t姓名\t性别\t班级\t出生日期\t\t电话号码\t\t");
        for (jiaocai jiaocai : jiaocais) {
			System.out.println( jiaocai.getStudent_id() + "\t" + 
					jiaocai.getJiaocaimingcheng() + "\t" + 
					jiaocai.getChubanshe() + "\t" + 
					jiaocai.getChubanshijian() + "\t" + 
				jiaocai.getGongxiandupaiming() + "\t" + 
				jiaocai.getZuozhengcailiao() + "\t" 
					);
        }
	}
	
	
	private static void addjiaocai(  String  student_id,
    String  jiaocaimingcheng,
    String chubanshe,
    String chubanshijian,
    int  gongxiandupaiming,
    String zuozhengcailiao) {
				jiaocai jiaocai  = new jiaocai ();
				  jiaocai.setStudent_id(student_id);
		          jiaocai.setJiaocaimingcheng(jiaocaimingcheng);
		        jiaocai.setChubanshe(chubanshe);
		         jiaocai.setChubanshijian(chubanshijian);
		       jiaocai.setGongxiandupaiming(gongxiandupaiming);
		       jiaocai.setZuozhengcailiao(zuozhengcailiao);
		        DAOFactory.getInstance().getjiaocaiDao().addjiaocai(jiaocai);
			}
	
	
	private static void updatejiaocai( String student_id,String shuxing,String value) {	
		//修改前
		getjiaocai(student_id);
		jiaocai jiaocai= DAOFactory.getInstance().getjiaocaiDao().getjiaocai(student_id);
		
		if(shuxing.equals("jiaocaimingcheng"))
		jiaocai.setJiaocaimingcheng(value);
		
		if(shuxing.equals("chubanshe"))
			jiaocai.setChubanshe(value);
		
		if(shuxing.equals("chubanshijian"))
			jiaocai.setChubanshijian(value);
		
		if(shuxing.equals("gongxiandupaiming"))
		{   int i=Integer.parseInt(value);
			jiaocai.setGongxiandupaiming(i);
		}
		if(shuxing.equals("zuozhengcailiao"))
			jiaocai.setZuozhengcailiao(value);
		
		
		DAOFactory.getInstance().getjiaocaiDao().updatejiaocai(jiaocai);
		//修改后
		getjiaocai(student_id);
	}
	
	private static void getjiaocai(String student_id) {	//获取数据库中学号为0510的学生信息
		jiaocai jiaocai= DAOFactory.getInstance().getjiaocaiDao().getjiaocai(student_id);
		
		
		System.out.println( jiaocai.getStudent_id() + "\t" + 
				jiaocai.getJiaocaimingcheng() + "\t" + 
				jiaocai.getChubanshe() + "\t" + 
				jiaocai.getChubanshijian() + "\t" + 
			jiaocai.getGongxiandupaiming() + "\t" + 
			jiaocai.getZuozhengcailiao() + "\t" 
				);
	}
	
	private static void deletejiaocai(String student_id) {	//删除数据库中学号为0510的学生信息
		DAOFactory.getInstance().getjiaocaiDao().deletejiaocai(student_id);
	}
	
	//////
	
	//////标准

	private static void getAllbiaozhuns() {
		List<biaozhun> biaozhuns = new ArrayList<biaozhun>();
		biaozhuns = DAOFactory.getInstance().getbiaozhunDao(). selectAllbiaozhun();
        //System.out.println("学号\t姓名\t性别\t班级\t出生日期\t\t电话号码\t\t");
        for (biaozhun biaozhun :biaozhuns) {
			System.out.println( biaozhun.getStudent_id() + "\t" + 
					biaozhun.getBiaozhunmingcheng() + "\t" + 
					biaozhun.getBiaozhunjibie()+ "\t" + 
					biaozhun.getFabushijian() + "\t" + 
					biaozhun.getZuozhengcailiao() + "\t" 
					
					);
        }
	}
	
	
	private static void addbiaozhun( String student_id,
	String		biaozhunmingcheng,
	String		biaozhunjibie,
	String		fabushijian,
		String	zuozhengcailiao
) {
				biaozhun biaozhun  = new biaozhun ();
				 biaozhun.setStudent_id(student_id);
            	 biaozhun.setBiaozhunmingcheng(biaozhunmingcheng);
            	 biaozhun.setBiaozhunjibie(biaozhunjibie);
            	 biaozhun.setFabushijian(fabushijian);
            	
            	 biaozhun.setZuozhengcailiao(zuozhengcailiao);
		        DAOFactory.getInstance().getbiaozhunDao().addbiaozhun(biaozhun);
			}
	
	
	private static void updatebiaozhun( String student_id,String shuxing,String value) {	
		//修改前
		System.out.println("改前");
		getbiaozhun(student_id);
		biaozhun biaozhun = DAOFactory.getInstance().getbiaozhunDao().getbiaozhun(student_id);
		
		if(shuxing.equals("biaozhunmingcheng"))
			biaozhun.setBiaozhunmingcheng(value);
		
		if(shuxing.equals("kanwumingcheng"))
			biaozhun.setBiaozhunjibie(value);
		
		if(shuxing.equals("fabushijian"))
			biaozhun.setFabushijian(value);
		
		if(shuxing.equals("zuozhengcailiao"))
			biaozhun.setZuozhengcailiao(value);
		
		
		DAOFactory.getInstance().getbiaozhunDao().updatebiaozhun(biaozhun);
		//修改后
		System.out.println("改后");
		getbiaozhun(student_id);
	}
	
	private static void getbiaozhun(String student_id) {	//获取数据库中学号为0510的学生信息
		biaozhun biaozhun= DAOFactory.getInstance().getbiaozhunDao().getbiaozhun(student_id);
		
		
		System.out.println( biaozhun.getStudent_id() + "\t" + 
				biaozhun.getBiaozhunmingcheng() + "\t" + 
				biaozhun.getBiaozhunjibie()+ "\t" + 
				biaozhun.getFabushijian() + "\t" + 
				biaozhun.getZuozhengcailiao() + "\t" 
				
				);
	}
	
	private static void deletebiaozhun(String student_id) {	//删除数据库中学号为0510的学生信息
		DAOFactory.getInstance().getbiaozhunDao().deletebiaozhun(student_id);
	}
	
	
	///////
	//
	//
	//
	//
	//
	
	
	private static void getAllzhuanlis() {
		List<zhuanli> zhuanlis = new ArrayList<zhuanli>();
		zhuanlis = DAOFactory.getInstance().getzhuanliDao(). selectAllzhuanli();
        //System.out.println("学号\t姓名\t性别\t班级\t出生日期\t\t电话号码\t\t");
        for (zhuanli zhuanli :zhuanlis) {
			System.out.println( zhuanli.getZhuanli_id() + "\t" + 
					zhuanli.getStudent_id() + "\t" + 
					zhuanli.getZhuanlimingcheng()+ "\t" + 
					zhuanli.getZhuanlileixing() + "\t" + 
					zhuanli.getFabushijian() + "\t"+
					zhuanli.getZhuanlizhuangtai()+ "\t"+
					
					zhuanli.getGongxiandupaiming()  + "\t"+
					zhuanli.getZuozhengcailiao()                               + "\t"
					);
        }
	}
	
	private static void addzhuanli( String	zhuanli_id,
	String	student_id,
	String	zhuanlimingcheng,
	String	zhuanlileixing,
	String	fabushijian,
	String	zhuanlizhuangtai,
	int	gongxiandupaiming,
	String	zuozhengcailiao
		) {
					    zhuanli zhuanli  = new zhuanli ();
					    zhuanli.setZhuanli_id(zhuanli_id);
		            	 zhuanli.setStudent_id(student_id);
		            	 zhuanli.setZhuanlimingcheng(zhuanlimingcheng);
		            	 zhuanli.setZhuanlileixing(zhuanlileixing);
		            	 zhuanli.setFabushijian(fabushijian);
		            	 zhuanli.setZhuanlizhuangtai(zhuanlizhuangtai);
		            	 zhuanli.setGongxiandupaiming(gongxiandupaiming);
		            	 zhuanli.setZuozhengcailiao(zuozhengcailiao);
				        DAOFactory.getInstance().getzhuanliDao().addzhuanli(zhuanli);
					}
			
	private static void updatezhuanli( String zhuanli_id,String shuxing,String value) {	
		//修改前
		System.out.println("改前");
		getzhuanli(zhuanli_id);
		zhuanli zhuanli = DAOFactory.getInstance().getzhuanliDao().getzhuanli(zhuanli_id);
		
		if(shuxing.equals("zhuanlimingcheng"))
			zhuanli.setZhuanlimingcheng(value);
		
		if(shuxing.equals("zhuanlileixing"))
			zhuanli.setZhuanlileixing(value);
		
		if(shuxing.equals("fabushijian"))
			zhuanli.setFabushijian(value);
		if(shuxing.equals("zhuanlizhuangtai"))
			zhuanli.setZhuanlizhuangtai(value);
		
		if(shuxing.equals("gongxiandupaiming"))
		{ int i=Integer.parseInt(value);
			zhuanli.setGongxiandupaiming(i);
		}
		if(shuxing.equals("zuozhengcailiao"))
			zhuanli.setZuozhengcailiao(value);
		
		
		DAOFactory.getInstance().getzhuanliDao().updatezhuanli(zhuanli);
		//修改后
		System.out.println("改后");
		getzhuanli(zhuanli_id);
	}
	private static void getzhuanli(String zhuanli_id) {	//获取数据库中学号为0510的学生信息
		zhuanli zhuanli= DAOFactory.getInstance().getzhuanliDao().getzhuanli(zhuanli_id);
		
		
		System.out.println( zhuanli.getZhuanli_id() + "\t" + 
				zhuanli.getStudent_id() + "\t" + 
				zhuanli.getZhuanlimingcheng()+ "\t" + 
				zhuanli.getZhuanlileixing() + "\t" + 
				zhuanli.getFabushijian() + "\t"+
				zhuanli.getZhuanlizhuangtai()+ "\t"+
				
				zhuanli.getGongxiandupaiming()                               + "\t"+
				zhuanli.getZuozhengcailiao()                               + "\t"
				);
	}
	
	

	private static void deletezhuanli(String zhuanli_id) {	//删除数据库中学号为0510的学生信息
		DAOFactory.getInstance().getzhuanliDao().deletezhuanli(zhuanli_id);
	}
	
	
	/////
	////
	///
	///
	////
	///
	
	
	private static void getAllbaogaos() {
		List<baogao> baogaos = new ArrayList<baogao>();
		baogaos = DAOFactory.getInstance().getbaogaoDao(). selectAllbaogao();
        //System.out.println("学号\t姓名\t性别\t班级\t出生日期\t\t电话号码\t\t");
        for (baogao baogao : baogaos) {
			System.out.println( baogao.getStudent_id() + "\t" + 
					baogao.getBaogaomingcheng()+ "\t" + 
					baogao.getBaogaoleixing()+ "\t" + 
					baogao.getBaogaoshijian() + "\t" + 
					baogao.getBaogaodanwei() + "\t" + 
					baogao.getGongxiandupaiming() + "\t" + 
					baogao.getZuozhengcailiao() + "\t");
        }
	}
	private static void addbaogao(  String	student_id,
	String	baogaomingcheng,
	String	baogaoleixing,
	String	baogaoshijian,
	String	baogaodanwei,
	int	gongxiandupaiming,
	String	zuozhengcailiao) {
		baogao   baogao  = new baogao ();
		 baogao .setStudent_id(student_id);
    	 baogao .setBaogaomingcheng(baogaomingcheng);
    	 baogao .setBaogaoleixing(baogaoleixing);
    	 baogao .setBaogaoshijian(baogaoshijian);
    	 baogao .setBaogaodanwei(baogaodanwei);
    	 baogao .setGongxiandupaiming(gongxiandupaiming);
    	 baogao .setZuozhengcailiao(zuozhengcailiao);
        DAOFactory.getInstance().getbaogaoDao().addbaogao(baogao);
	}
	
	private static void updatebaogao( String student_id,String shuxing,String value) {	
		//修改前
		System.out.println("改前");
		getbaogao(student_id);
		baogao baogao = DAOFactory.getInstance().getbaogaoDao().getbaogao(student_id);
		
		if(shuxing.equals("baogaomingcheng"))
			baogao.setBaogaomingcheng(value);
		
		if(shuxing.equals("baogaoleixing"))
			baogao.setBaogaoleixing(value);
		
		if(shuxing.equals("baogaoshijian"))
			baogao.setBaogaoshijian(value);
		
		if(shuxing.equals("baogaodanwei"))
			baogao.setBaogaodanwei(value);
		
		if(shuxing.equals("gongxiandupaiming"))
		{ int i=Integer.parseInt(value);
			baogao.setGongxiandupaiming(i);
		}
		if(shuxing.equals("zuozhengcailiao"))
			baogao.setZuozhengcailiao(value);
		DAOFactory.getInstance().getbaogaoDao().updatebaogao(baogao);
		//修改后
		System.out.println("改后");
		getbaogao(student_id);
	}
	private static void getbaogao(String student_id) {	//获取数据库中学号为0510的学生信息
		baogao baogao = DAOFactory.getInstance().getbaogaoDao().getbaogao(student_id);
		
		System.out.println( baogao.getStudent_id() + "\t" + 
				baogao.getBaogaomingcheng()+ "\t" + 
				baogao.getBaogaoleixing()+ "\t" + 
				baogao.getBaogaoshijian() + "\t" + 
				baogao.getBaogaodanwei() + "\t" + 
				baogao.getGongxiandupaiming() + "\t" + 
				baogao.getZuozhengcailiao() + "\t");
	}
	
	private static void deletebaogao(String student_id) {	//删除数据库中学号为0510的学生信息
		DAOFactory.getInstance().getbaogaoDao().deletebaogao(student_id);
	}
	
	
	//////
	/////
	
	/////
	////
	private static void getAllpingtais() {
		List<pingtai> pingtais = new ArrayList<pingtai>();
		pingtais = DAOFactory.getInstance().getpingtaiDao(). selectAllpingtai();
        //System.out.println("学号\t姓名\t性别\t班级\t出生日期\t\t电话号码\t\t");
        for (pingtai pingtai :pingtais) {
			System.out.println( pingtai.getStudent_id() + "\t" + 
					pingtai.getPingtaimingcheng()+ "\t" + 
				
					pingtai.getFuwudanwei()+ "\t" + 
					pingtai.getShangxianshijian() + "\t" + 
					pingtai.getGongxiandupaiming() + "\t" + 
					pingtai.getZuozhengcailiao() + "\t");
        }
	}
	private static void addbaogao(  String student_id,
	String	pingtaimingcheng,
	String	fuwudanwei,
	String	shangxianshijian,
	int	gongxiandupaiming,
	String	zuozhengcailiao) {
		pingtai   pingtai  = new pingtai ();
		pingtai .setStudent_id(student_id);
		pingtai .setPingtaimingcheng(pingtaimingcheng);
    	
    	pingtai.setFuwudanwei(fuwudanwei);
    	pingtai.setShangxianshijian(shangxianshijian);
    	 pingtai .setGongxiandupaiming(gongxiandupaiming);
    	 pingtai.setZuozhengcailiao(zuozhengcailiao);
        DAOFactory.getInstance().getpingtaiDao().addpingtai(pingtai);
	}
	
	private static void updatepingtai( String student_id,String shuxing,String value) {	
		//修改前
		System.out.println("改前");
		getpingtai(student_id);
		pingtai pingtai = DAOFactory.getInstance().getpingtaiDao().getpingtai(student_id);
		
		if(shuxing.equals("pingtaimingcheng"))
			pingtai.setPingtaimingcheng(value);
		
		if(shuxing.equals("fuwudanwei"))
			pingtai.setFuwudanwei(value);
		
		if(shuxing.equals("shangxianshijian"))
			pingtai.setShangxianshijian(value);
		
		
		
		if(shuxing.equals("gongxiandupaiming"))
		{ int i=Integer.parseInt(value);
		pingtai.setGongxiandupaiming(i);
		}
		if(shuxing.equals("zuozhengcailiao"))
			pingtai.setZuozhengcailiao(value);
		DAOFactory.getInstance().getpingtaiDao().updatepingtai(pingtai);
		//修改后
		System.out.println("改后");
		getpingtai(student_id);
	}
	private static void getpingtai(String student_id) {	//获取数据库中学号为0510的学生信息
		pingtai pingtai = DAOFactory.getInstance().getpingtaiDao().getpingtai(student_id);
		
		System.out.println( pingtai.getStudent_id() + "\t" + 
				pingtai.getPingtaimingcheng()+ "\t" + 
			
				pingtai.getFuwudanwei()+ "\t" + 
				pingtai.getShangxianshijian() + "\t" + 
				pingtai.getGongxiandupaiming() + "\t" + 
				pingtai.getZuozhengcailiao() + "\t");
	}
	
	private static void deletepingtai(String student_id) {	//删除数据库中学号为0510的学生信息
		DAOFactory.getInstance().getpingtaiDao().deletepingtai(student_id);
	}
	
	
	public static void jiaocais()
	{
		System.out.println("1: 查询");
		System.out.println("2: 修改");
		System.out.println("3: 增添");
		System.out.println("4: 删除");
		System.out.println("5: 列所有");
		int i;
		Scanner input = new Scanner( System.in);
		i=input.nextInt();
		if(i==1)
		{
			System.out.println("输入要查找id");
			String id;
			id=input.next();
			getjiaocai(id);
		}
		
		if(i==2)
		{
			System.out.println("输入要修改id ，属性，value");
			System.out.println("id:");
			String id;
			id=input.next();
			System.out.println("属性");
			String shuxing;
			shuxing=input.next();
			String value;
			System.out.println("value:");
			value=input.next();
			updatejiaocai(id,shuxing,value);
		}
		if(i==3)
		{
			System.out.println("输入id");
			String id;
			id=input.next();
			System.out.println("输入名称");
			String mingcheng;
			mingcheng=input.next();
			System.out.println("输入出版社");
			String chubanshe;
			chubanshe=input.next();
			System.out.println("输入出版时间");
			String chubanshijian;
			chubanshijian=input.next();
			System.out.println("输入共享度排名");
			int gongxiang;
			gongxiang=input.nextInt();
			System.out.println("输入材料");
			String cailiao;
			cailiao=input.next();
			addjiaocai(id,mingcheng,chubanshe,chubanshijian,gongxiang,cailiao);
			
		}
		if(i==4)
		{
			System.out.println("输入要删除id");
			String   id;
			id=input.next();
 			deletejiaocai(id);
			
		}
		if(i==5)
		{
			getAlljiaocais();
		}
	}
	
	
	public static void lunwens()
	{
		System.out.println("1: 查询");
		System.out.println("2: 修改");
		System.out.println("3: 增添");
		System.out.println("4: 删除");
		System.out.println("5: 列所有");
		int i;
		Scanner input = new Scanner( System.in);
		i=input.nextInt();
		if(i==1)
		{
			System.out.println("输入要查找id");
			String id;
			id=input.next();
			getlunwen(id);
		}
		if(i==2)
		{
			System.out.println("输入要修改id ，属性，value");
			System.out.println("id:");
			String id;
			id=input.next();
			System.out.println("属性");
			String shuxing;
			shuxing=input.next();
			String value;
			System.out.println("value:");
			value=input.next();
			updatelunwen(id,shuxing,value);
		}
		if(i==3)
		{
			System.out.println("输入id");
			String id;
			id=input.next();
			System.out.println("输入名称");
			String mingcheng;
			mingcheng=input.next();
			System.out.println("输入刊物");
			String kanwu;
			kanwu=input.next();
			System.out.println("输入论文状态");
			String zhuangtai;
			zhuangtai=input.next();
			System.out.println("输入发表时间");
			String time;
			time=input.next();
			System.out.println("输入类型");
			String leixing;
			leixing=input.next();
			System.out.println("输入情况");
			String qingkuang;
			qingkuang=input.next();
			addlunwen(id,mingcheng,kanwu,zhuangtai,time,leixing,qingkuang);
		}
		if(i==4)
		{

			System.out.println("输入要删除id");
			String   id;
			id=input.next();
 			deletelunwen(id);
		}
		if(i==5)
		{
			getAlllunwens();
		}
		
	}
	public static void biaozhuns()
	{
		System.out.println("1: 查询");
		System.out.println("2: 修改");
		System.out.println("3: 增添");
		System.out.println("4: 删除");
		System.out.println("5: 列所有");
		int i;
		Scanner input = new Scanner( System.in);
		i=input.nextInt();
		if(i==1)
		{
			System.out.println("输入要查找id");
			String id;
			id=input.next();
			getbiaozhun(id);
		}
		if(i==2)
		{
			System.out.println("输入要修改id ，属性，value");
			System.out.println("id:");
			String id;
			id=input.next();
			System.out.println("属性");
			String shuxing;
			shuxing=input.next();
			String value;
			System.out.println("value:");
			value=input.next();
			updatebiaozhun(id,shuxing,value);
		}
		if(i==3)
		{
			System.out.println("输入id");
			String id;
			id=input.next();
			System.out.println("输入名称");
			String mingcheng;
			mingcheng=input.next();
			System.out.println("输入标准级别");
			String jibie;
			jibie=input.next();
			System.out.println("输入发布时间");
			String time;
			time=input.next();
			System.out.println("输入佐证材料");
			String cailiao;
			cailiao=input.next();
			
			addbiaozhun(id,mingcheng,jibie,time,cailiao);
		}
		if(i==4)
		{

			System.out.println("输入要删除id");
			String   id;
			id=input.next();
 			deletezhuanli(id);
		}
		if(i==5)
		{
			getAllzhuanlis();
		}
	}
	public static void zhuanlis()
	{
		System.out.println("1: 查询");
		System.out.println("2: 修改");
		System.out.println("3: 增添");
		System.out.println("4: 删除");
		System.out.println("5: 列所有");
		int i;
		Scanner input = new Scanner( System.in);
		i=input.nextInt();
		if(i==1)
		{
			System.out.println("输入要查找id");
			String id;
			id=input.next();
			getzhuanli(id);
		}
		if(i==2)
		{
			System.out.println("输入要修改id ，属性，value");
			System.out.println("id:");
			String id;
			id=input.next();
			System.out.println("属性");
			String shuxing;
			shuxing=input.next();
			String value;
			System.out.println("value:");
			value=input.next();
			updatezhuanli(id,shuxing,value);
		}
		if(i==3)
		{
			System.out.println("输入专利id");
			String id;
			id=input.next();
			System.out.println("输入学生id");
			String id2;
			id2=input.next();
			System.out.println("输入名称");
			String mingcheng;
			mingcheng=input.next();
			System.out.println("输入专利类型");
			String leixing;
			leixing=input.next();
		
			System.out.println("输入发布时间");
			String time;
			time=input.next();
			System.out.println("输入专利状态");
			String zt;
			zt=input.next();
			System.out.println("输入共享排名");
			int pm;
			pm=input.nextInt();
			System.out.println("输入佐证材料");
			String cailiao;
			cailiao=input.next();
			
			addzhuanli(id,id2,mingcheng,leixing,time,zt,pm,cailiao);
		}
		if(i==4)
		{

			System.out.println("输入要删除id");
			String   id;
			id=input.next();
 			deletezhuanli(id);
		}
		if(i==5)
		{
			getAllzhuanlis();
		}
	}
	public static void baogaos()
	{
		System.out.println("1: 查询");
		System.out.println("2: 修改");
		System.out.println("3: 增添");
		System.out.println("4: 删除");
		System.out.println("5: 列所有");
		int i;
		Scanner input = new Scanner( System.in);
		i=input.nextInt();
		if(i==1)
		{
			System.out.println("输入要查找id");
			String id;
			id=input.next();
			getbaogao(id);
		}
		if(i==2)
		{
			System.out.println("输入要修改id ，属性，value");
			System.out.println("id:");
			String id;
			id=input.next();
			System.out.println("属性");
			String shuxing;
			shuxing=input.next();
			String value;
			System.out.println("value:");
			value=input.next();
			updatebaogao(id,shuxing,value);
		}
		if(i==3)
		{
			System.out.println("输入id");
			String id;
			id=input.next();
			
			System.out.println("输入名称");
			String mingcheng;
			mingcheng=input.next();
			System.out.println("输入报告类型");
			String leixing;
			leixing=input.next();
		
			System.out.println("输入发布时间");
			String time;
			time=input.next();
			System.out.println("输入报告单位");
			String danwei;
			danwei=input.next();
			System.out.println("输入共享排名");
			int pm;
			pm=input.nextInt();
			System.out.println("输入佐证材料");
			String cailiao;
			cailiao=input.next();
			
			addbaogao(id,mingcheng,leixing,time,danwei,pm,cailiao);
		}
		if(i==4)
		{

			System.out.println("输入要删除id");
			String   id;
			id=input.next();
 			deletebaogao(id);
		}
		if(i==5)
		{
			getAllbaogaos();
		}
	}
	public static void pingtais()
	{
		System.out.println("1: 查询");
		System.out.println("2: 修改");
		System.out.println("3: 增添");
		System.out.println("4: 删除");
		System.out.println("5: 列所有");
		int i;
		Scanner input = new Scanner( System.in);
		i=input.nextInt();
		if(i==1)
		{
			System.out.println("输入要查找id");
			String id;
			id=input.next();
			getpingtai(id);
		}
		if(i==2)
		{
			System.out.println("输入要修改id ，属性，value");
			System.out.println("id:");
			String id;
			id=input.next();
			System.out.println("属性");
			String shuxing;
			shuxing=input.next();
			String value;
			System.out.println("value:");
			value=input.next();
			updatepingtai(id,shuxing,value);
		}
		if(i==3)
		{
			System.out.println("输入id");
			String id;
			id=input.next();
			
			System.out.println("输入名称");
			String mingcheng;
			mingcheng=input.next();
			System.out.println("输入服务单位");
			String danwei;
			danwei=input.next();
		
			System.out.println("输入上线时间");
			String time;
			time=input.next();
			
			System.out.println("输入共享排名");
			int pm;
			pm=input.nextInt();
			System.out.println("输入佐证材料");
			String cailiao;
			cailiao=input.next();
			
			addbaogao(id,mingcheng,danwei,time,pm,cailiao);
		}
		if(i==4)
		{

			System.out.println("输入要删除id");
			String   id;
			id=input.next();
 			deletepingtai(id);
		}
		if(i==5)
		{
			getAllpingtais();
		}
	}
	public static void caidan()
	{    int i;
	Scanner input = new Scanner( System.in);
		System.out.println("1: 论文");
		System.out.println("2: 教材");
		System.out.println("3: 标准");
		System.out.println("4: 专利");
		System.out.println("5: 报告");
		System.out.println("6: 开发平台");
		i=input.nextInt();
		if(i==1)
		{
			lunwens();
			caidan();
		}
		if(i==2)
		{
			jiaocais();
			caidan();
		}
		if(i==3)
		{
			biaozhuns();
			caidan();
		}
		if(i==4)
		{
			zhuanlis();
			caidan();
		}
		if(i==5)
		{
			baogaos();
			caidan();
		}
		if(i==6)
		{
			pingtais();
			caidan();
		}
	}
	
	 public static void main(String[] args){
	    	caidan();
	    }
	
	
	
	
	
}
