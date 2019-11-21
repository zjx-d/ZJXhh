import com.zjx.po.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;

import java.util.List;

public class Test {

    private SessionFactory sessionFactory;

    private Session session;

    private Transaction tx;


    @org.junit.Before
    public void before() {
//        //1.获取sessionFactory 会话工厂
////        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
////        //2.生产会话 通过opensession 获取session对象
////        Session session = sessionFactory.openSession();
////        //3.开启一个事务
////        Transaction transaction = session.beginTransaction();
////        //执行查询  get(要查询的实体类型，参数)
////        Student load = session.load(Student.class, 1);
////        System.out.println(load);
////        transaction.commit();
////        session.close();
////        session=sessionFactory.openSession();
////        transaction=session.beginTransaction();
////        Student student = session.load(Student.class, 1);
////        System.out.println("student="+student);
////
////        String hql1="from Student where id=?";
////        String hql2="from Student where id=:id";
////        Query query = session.createQuery(hql2);
////        query.setParameter("id",2);
////
////        //查询全部
////        Query query1 = session.createQuery("from com.zjx.po.Student");
////        List<Student> list = query1.list();
////        for(Student student1:list){
////            System.out.println(student1);
////        }

        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

    }
    @org.junit.Test
    public void Test(){
//        Student student = session.load(Student.class,1);
//        System.out.println(student);
        //增加
            Student student = new Student();
            student.setName("里哈");
            session.save(student);
    }
    @org.junit.Test
    public void delete(){
        //删除
        Student stu = session.get(Student.class,10);
        if(stu!=null){
            session.delete(stu);
        }
    }
    @org.junit.Test
    public void update(){
        //修改
        Student stu = session.get(Student.class,5);
        stu.setName("王旺");
        session.update(stu);
    }

    /*
    *
    * 新增或是修改
    * 如果查询到数据 那么执行 修改操作
    * 否则 执行 添加操作
    * */
    @org.junit.Test
    public void SaveOrUpdate(){
        Student stu = new Student();
        stu.setId(5);
        stu.setName("哈哈");
        session.saveOrUpdate(stu);
    }
    @After
    public void after(){
        tx.commit();
        session.close();
    }
}