package widthFirstTreeTraversal;

import java.util.ArrayList;

import java.util.List;

 

public class TestEmp{

 

       private int id;

       private int pid;

      

       private List<TestEmp> slaves = new ArrayList<>();

      

       public TestEmp(int id, int pid) {

             super();

             this.id = id;

             this.pid = pid;

       }

      

       public TestEmp() {

             super();

       }

 

       public int getId() {

             return id;

       }

 

       public void setId(int id) {

             this.id = id;

       }

 

       public int getPid() {

             return pid;

       }

 

       public void setPid(int pid) {

             this.pid = pid;

       }

 

       public List<TestEmp> getSlaves() {

             return slaves;

       }

 

       public void setSlaves(List<TestEmp> slaves) {

             this.slaves = slaves;

       }

 

       public void addSlaves(TestEmp slave) {

             this.slaves.add(slave);

       }

      

       public void removeSlaves(TestEmp slave) {

             this.slaves.remove(slave);

       }

 

       @Override

       public String toString() {

             return "TestEmp [id=" + id + ", pid=" + pid + ", slavesXXX____ " + slaves + " ___XXX]";

       }

      

}