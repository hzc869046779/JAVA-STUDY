package javaSenior.JavaBaseClass;

import sun.misc.Cleaner;

/**
 * java 没有提供析构函数支持，但是仍然给了收尾方法。每一个实例化对象在回首之前给一个
 * 喘息机会。
 *
 * System.finalize()  一直实现,但是不推荐使用了
 */

/*public class CleanerStudy {
    public static void main(String[] args) {
        Member member = new Member();
        member = null;
        System.gc();

        try (MemberCleaning mc = new MemberCleaning()){

        }catch (Exception e){}

    }
}*/

class Member implements Runnable{
    public Member(){
        System.out.println("在一个明媚的上午，hzc诞生了");
    }

    /**
    @Override
    protected void finalize() throws Throwable {
        System.out.println("[回收]最后还是要飞天");
        throw new Exception("我还想在人世间");
    }
    */

    @Override
    public void run() {
        System.out.println("最终还是要死");
    }
}

/*

class  MemberCleaning implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();
    private Member member;
    private Cleaner.Cleanable cleanable;
    public MemberCleaning(){
        this.member = new Member();
        this.cleanable = this.cleaner.register(this, this.member);

    }

    @Override
    public void close() throws Exception{
        this.cleanable.clean(); //启动多线程
    }
}
*/
