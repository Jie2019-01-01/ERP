package cn.itcast.erp.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import cn.itcast.erp.auth.menu.vo.MenuModel;

public class CodeGenerator {

	private static Class clazz;
	private static String pack;
	private static String packPath;
	private static String modelName;
	private static String big;
	private static String small;
	private static String first;
	
	
	public static void main(String[] args) throws Exception {
		//资源初始化DepModel
		dataInit(MenuModel.class);
		createDirs();
		QueryModel();
		dao();
		impl();
		ebi();
		ebo();
		action();
		appXml();
		hbmXml();
		System.out.println("struts中的配置");
		System.out.println("hbm.xml中的映射关系");
		System.out.println("自定义查询条件");
	}
	
	// 数据初始化
	public static void dataInit(Class clazz) throws Exception {
		String modelPack = clazz.getPackage().getName();	//cn.itcast.erp.auth.dep.vo
		pack = modelPack.substring(0, modelPack.lastIndexOf(".")); //cn.itcast.erp.auth.dep 
		packPath = pack.replaceAll("\\.", "/");	// cn/itcast/erp/auth/dep
		modelName = clazz.getSimpleName();	// DepModel
		big = modelName.substring(0, modelName.length()-5);	// Dep
		small = big.substring(0,1).toLowerCase() + big.substring(1); // dep
		first = small.substring(0,1);
	}
	
	// 创建目录
	public static void createDirs() {
		File f = new File("src/main/java/"+packPath+"/action");
		f.mkdirs();
		
		f = new File("src/main/java/"+packPath+"/business/ebi");
		f.mkdirs();
		
		f = new File("src/main/java/"+packPath+"/business/ebo");
		f.mkdirs();
		
		f = new File("src/main/java/"+packPath+"/dao/dao");
		f.mkdirs();
		
		f = new File("src/main/java/"+packPath+"/dao/impl");
		f.mkdirs();
	}
	
	//queryModel
	public static void QueryModel() throws Exception{
		File f = new File("src/main/java/"+packPath+"/vo/"+big+"QueryModel.java");
		if(f.exists()) return;
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pack+".vo;");
		bw.newLine();bw.newLine();
		
		bw.write("import cn.itcast.erp.utils.base.BaseQueryModel;");
		bw.newLine();bw.newLine();
		
		bw.write("public class "+big+"QueryModel extends "+modelName+" implements BaseQueryModel{");
		bw.newLine();bw.newLine();
		
		bw.write("}");
		
		bw.flush();
		bw.close();
	}
	
	//dao
	public static void dao() throws Exception{
		File f = new File("src/main/java/"+packPath+"/dao/dao/"+big+"Dao.java");
		if(f.exists()) return;
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pack+".dao.dao;");
		bw.newLine();bw.newLine();
		
		bw.write("import "+pack+".vo."+modelName+";");
		bw.newLine();
		bw.write("import cn.itcast.erp.utils.base.BaseDao;");
		bw.newLine();bw.newLine();
		
		bw.write("public interface "+big+"Dao extends BaseDao<"+modelName+">{");
		bw.newLine();bw.newLine();
		bw.write("}");
		
		bw.flush();
		bw.close();
	}
	
	//impl
	public static void impl() throws Exception{
		File f = new File("src/main/java/"+packPath+"/dao/impl/"+big+"Impl.java");
		if(f.exists()) return;
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pack+".dao.impl;");
		bw.newLine();bw.newLine();
		
		bw.write("import org.hibernate.criterion.DetachedCriteria;");
		bw.newLine();
		bw.write("import "+pack+".dao.dao."+big+"Dao;");
		bw.newLine();
		bw.write("import "+pack+".vo."+modelName+";");
		bw.newLine();
		bw.write("import cn.itcast.erp.utils.base.BaseImpl;");
		bw.newLine();
		bw.write("import cn.itcast.erp.utils.base.BaseQueryModel;");
		bw.newLine();bw.newLine();
		
		bw.write("public class "+big+"Impl extends BaseImpl<"+modelName+"> implements "+big+"Dao {");
		bw.newLine();bw.newLine();
		
		bw.write("	public void doQbc(DetachedCriteria dc, BaseQueryModel bqm) {");
		bw.newLine();

		bw.write("		//TODO:自定义查询条件");
		bw.newLine();
		
		bw.write("	}");
		
		bw.newLine();bw.newLine();
		bw.write("}");
		
		bw.flush();
		bw.close();
	}
	
	//ebi
	public static void ebi() throws Exception{
		File f = new File("src/main/java/"+packPath+"/business/ebi/"+big+"Ebi.java");
		if(f.exists()) return;
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pack+".business.ebi;");
		bw.newLine();bw.newLine();
		
		bw.write("import "+pack+".vo."+modelName+";");
		bw.newLine();
		bw.write("import cn.itcast.erp.utils.base.BaseEbi;");
		bw.newLine();bw.newLine();
		
		bw.write("public interface "+big+"Ebi extends BaseEbi<"+modelName+">{");
		bw.newLine();bw.newLine();
		bw.write("}");
		
		bw.flush();
		bw.close();
	}
	
	//ebo
	public static void ebo() throws Exception{
		File f = new File("src/main/java/"+packPath+"/business/ebo/"+big+"Ebo.java");
		if(f.exists()) return;
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pack+".business.ebo;");
		bw.newLine();bw.newLine();
		
		bw.write("import java.util.List;");
		bw.newLine();
		bw.write("import org.springframework.transaction.annotation.Transactional;");
		bw.newLine();
		bw.write("import "+pack+".business.ebi."+big+"Ebi;");
		bw.newLine();
		bw.write("import "+pack+".dao.dao."+big+"Dao;");
		bw.newLine();
		bw.write("import "+pack+".vo."+big+"Model;");
		bw.newLine();
		bw.write("import cn.itcast.erp.utils.base.BaseQueryModel;");
		bw.newLine();bw.newLine();
		
		bw.write("@Transactional");
		bw.newLine();
		bw.write("public class "+big+"Ebo implements "+big+"Ebi {");
		bw.newLine();bw.newLine();
		
		bw.write("	private "+big+"Dao "+small+"Dao;");
		bw.newLine();
		bw.write("	public void set"+big+"Dao("+big+"Dao "+small+"Dao) {this."+small+"Dao = "+small+"Dao;}");
		bw.newLine();bw.newLine();
		bw.write("	public List<"+modelName+"> list() {");
		bw.newLine();
		bw.write("		return "+small+"Dao.list();");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public void save("+modelName+" "+first+"m) {");
		bw.newLine();
		bw.write("		"+small+"Dao.save("+first+"m);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public void update("+modelName+" "+first+"m) {");
		bw.newLine();
		bw.write("		"+small+"Dao.update("+first+"m);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public "+modelName+" getByUuid(Long uuid) {");
		bw.newLine();
		bw.write("		return "+small+"Dao.getByUuid(uuid);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public void delete("+modelName+" "+first+"m) {");
		bw.newLine();
		bw.write("		"+small+"Dao.delete("+first+"m);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public List<"+modelName+"> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {");
		bw.newLine();
		bw.write("		return "+small+"Dao.list(bqm,curPage, pageCount);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public Integer getCount(BaseQueryModel bqm) {");
		bw.newLine();
		bw.write("		return "+small+"Dao.getCount(bqm);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		
		bw.write("}");
		
		bw.flush();
		bw.close();
	}
	
	// action
	public static void action() throws Exception{
		File f = new File("src/main/java/"+packPath+"/action/"+big+"Action.java");
		if(f.exists()) return;
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pack+".action;");
		bw.newLine();bw.newLine();
		bw.write("import java.util.List;");
		bw.newLine();
		bw.write("import "+pack+".business.ebi."+big+"Ebi;");
		bw.newLine();
		bw.write("import "+pack+".vo."+modelName+";");
		bw.newLine();
		bw.write("import "+pack+".vo."+big+"QueryModel;");
		bw.newLine();
		bw.write("import cn.itcast.erp.utils.base.BaseAction;");
		bw.newLine();bw.newLine();
		bw.write("public class "+big+"Action extends BaseAction{");
		bw.newLine();bw.newLine();
		bw.write("	private "+big+"Ebi "+small+"Ebi;");
		bw.newLine();
		bw.write("	public void set"+big+"Ebi("+big+"Ebi "+small+"Ebi) {this."+small+"Ebi = "+small+"Ebi;}");
		bw.newLine();bw.newLine();
		bw.write("	public "+modelName+" "+first+"m = new "+modelName+"();");
		bw.newLine();
		bw.write("	public "+big+"QueryModel "+first+"qm = new "+big+"QueryModel();");
		bw.newLine();bw.newLine();
		bw.write("	public String list() {");
		bw.newLine();
		bw.write("		setRecords("+small+"Ebi.getCount("+first+"qm));");
		bw.newLine();
		bw.write("		List<"+modelName+"> "+small+"List = "+small+"Ebi.list("+first+"qm, curPage, pageCount);");
		bw.newLine();
		bw.write("		put(\""+small+"List\", "+small+"List);");
		bw.newLine();
		bw.write("		return \"list\";");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public String input() {");
		bw.newLine();
		bw.write("		if("+first+"m.getUuid()!=null) {");
		bw.newLine();
		bw.write("			"+first+"m = "+small+"Ebi.getByUuid("+first+"m.getUuid());");
		bw.newLine();
		bw.write("		}");
		bw.newLine();
		bw.write("		return \"input\";");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public String saveOrUpdate() {");
		bw.newLine();
		bw.write("		if("+first+"m.getUuid()!=null) {");
		bw.newLine();
		bw.write("			"+small+"Ebi.update("+first+"m);");
		bw.newLine();
		bw.write("		}else {");
		bw.newLine();
		bw.write("			"+small+"Ebi.save("+first+"m);");
		bw.newLine();
		bw.write("		}");
		bw.newLine();
		bw.write("		return \"toList\";");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("	public String delete() {");
		bw.newLine();
		bw.write("		"+small+"Ebi.delete("+first+"m);");
		bw.newLine();
		bw.write("		return \"toList\";");
		bw.newLine();
		bw.write("	}");
		bw.newLine();bw.newLine();
		bw.write("}");
		
		bw.flush();
		bw.close();
	}
	
	//applicationContext-*.xml
	public static void appXml() throws Exception{
		File f = new File("src/main/resources/spring/applicationContext-"+small+".xml");
		if(f.exists()) return;
		f.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bw.newLine();
		bw.write("<beans xmlns=\"http://www.springframework.org/schema/beans\"");
		bw.newLine();
		bw.write("    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		bw.newLine();
		bw.write("    xsi:schemaLocation=\"http://www.springframework.org/schema/beans");
		bw.newLine();
		bw.write("            http://www.springframework.org/schema/beans/spring-beans-2.5.xsd\">");
		bw.newLine();bw.newLine();
		bw.write("	<bean id=\""+small+"Action\" class=\""+pack+".action."+big+"Action\" scope=\"prototype\">");
		bw.newLine();
		bw.write("		<property name=\""+small+"Ebi\" ref=\""+small+"Ebi\"/>");
		bw.newLine();
		bw.write("	</bean>");
		bw.newLine();bw.newLine();
		bw.write("	<bean id=\""+small+"Ebi\" class=\""+pack+".business.ebo."+big+"Ebo\">");
		bw.newLine();
		bw.write("		<property name=\""+small+"Dao\" ref=\""+small+"Dao\"/>");
		bw.newLine();
		bw.write("	</bean>");
		bw.newLine();bw.newLine();
		bw.write("	<bean id=\""+small+"Dao\" class=\""+pack+".dao.impl."+big+"Impl\">");
		bw.newLine();
		bw.write("		<property name=\"sessionFactory\" ref=\"sessionFactory\"/>");
		bw.newLine();
		bw.write("	</bean>");
		bw.newLine();
		bw.write("</beans>");
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
	
	//xxx.hbm.xml
	public static void hbmXml() throws Exception{
		File f = new File("src/main/java/"+packPath+"/vo/"+modelName+".hbm.xml");
		if(f.exists()) return;
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bw.newLine();
		bw.write("<!DOCTYPE hibernate-mapping PUBLIC");
		bw.newLine();
		bw.write("        \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
		bw.newLine();
		bw.write("        \"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">");
		bw.newLine();
		bw.write("<hibernate-mapping>");
		bw.newLine();
		bw.write("	<class name=\""+pack+".vo."+modelName+"\" table=\"tbl_"+small+"\">");
		bw.newLine();bw.newLine();
		bw.write("	</class>");
		bw.newLine();
		bw.write("</hibernate-mapping>");
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
}
