/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.College.Program;
import Business.Courses.Courses;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CollegeOrganization;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.CollegeAdminRole;
import Business.Role.ProfessorRole;
import Business.Role.ProgramCoordinatorRole;
import Business.Role.ProgramDirectorRole;
import Business.Role.RARole;
import Business.Role.StudentRole;
import Business.Role.SystemAdminRole;
import Business.Role.TARole;
import Business.UserAccount.UserAccount;
import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeWindow;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.net.MalformedURLException;

/**
 *
 * @author krunal
 */
public class ConfigureABusiness {

    public static EcoSystem Configure() {

          
        EcoSystem ecosystem = new EcoSystem();

        Network usa = ecosystem.createAndAddNetwork();
        usa.setName("United States of America");
        Enterprise neu = usa.getEnterpriseDirectory().createAndAddEnterprise("Northeastern University", Enterprise.EnterpriseType.University);
        CollegeOrganization neucoe = (CollegeOrganization) neu.getOrganizationDirectory().createOrganization(Organization.Type.College, "College of Engineering");
        
        // Organization neucoe = neu.getOrganizationDirectory().createOrganization(Organization.Type.College, "College of Engineering");
        
        Organization neuccis = neu.getOrganizationDirectory().createOrganization(Organization.Type.College, "College of Computer Science");
        Employee emp1 = neucoe.getEmployeeDirectory().createEmployee("COEEMP1");
        Employee emp2 = neuccis.getEmployeeDirectory().createEmployee("CCISEMP1");

        Employee emp3 = neucoe.getEmployeeDirectory().createEmployee("CollgeAdmin");
        UserAccount ua1 = neucoe.getUserAccountDirectory().createUserAccount("ca", "ca", emp3, new CollegeAdminRole());

        Employee employee = ecosystem.getEmployeeDirectory().createEmployee("RRH");

        UserAccount ua = ecosystem.getUserAccountDirectory().createUserAccount("admin", "123", employee, new SystemAdminRole());
        Employee neuemp = neu.getEmployeeDirectory().createEmployee("NEU Admin");
        UserAccount neuua = neu.getUserAccountDirectory().createUserAccount("a", "a", neuemp, new AdminRole());

        Employee emp4 = ecosystem.getEmployeeDirectory().createEmployee("COEEMP4");
        UserAccount pd = neucoe.getUserAccountDirectory().createUserAccount("pd", "pd", emp4, new ProgramDirectorRole());
        Employee emp5 = ecosystem.getEmployeeDirectory().createEmployee("COEEMP5");
        UserAccount pc = neucoe.getUserAccountDirectory().createUserAccount("pc", "pc", emp5, new ProgramCoordinatorRole());

        Employee emp6 = ecosystem.getEmployeeDirectory().createEmployee("COESTU1");
        UserAccount stu1 = neucoe.getUserAccountDirectory().createUserAccount("s1", "s1", emp6, new StudentRole());
        Employee emp7 = ecosystem.getEmployeeDirectory().createEmployee("COESTU2");
        UserAccount stu2 = neucoe.getUserAccountDirectory().createUserAccount("s2", "s2", emp7, new StudentRole());

        Employee emp8 = ecosystem.getEmployeeDirectory().createEmployee("COEPROF1");
        UserAccount prof1 = neucoe.getUserAccountDirectory().createUserAccount("p1", "p1", emp8, new ProfessorRole());
        Employee emp9 = ecosystem.getEmployeeDirectory().createEmployee("COETA1");
        UserAccount t1 = neucoe.getUserAccountDirectory().createUserAccount("t1", "t1", emp7, new TARole());
        TARole t1r = (TARole) t1.getRole();
        
        
        Employee emp10 = ecosystem.getEmployeeDirectory().createEmployee("COERA1");
        UserAccount r1 = neucoe.getUserAccountDirectory().createUserAccount("r1", "r1", emp7, new RARole());
        RARole r1r = (RARole) r1.getRole();
        
        ProfessorRole p1r = (ProfessorRole)prof1.getRole();
        p1r.AssignRA(r1);

        Program prg = neucoe.getPD().createProgram("Information Systems");
        prg.setProgramCoordinator(pc);
        prg.setProgramDirector(pd);
        //prg.setProfessor(prof1);
        Courses ads = prg.getCourses().createCourse(1000, "ADS", "Approved", 10);
        ads.setProfessor(prof1);
        ads.setProgram(prg);
        ads.AssignTA(t1);
        t1r.setCourse(ads);
        prg.subscribeProgram(stu1);
        
         ads.RegisterCourse(stu1);
         int seats = ads.getTotalSeats();
        // coursenames += c.getCourseName() + ",";
         seats -= 1;
         ads.setTotalSeats(seats);
        
        
        return ecosystem;
    }

}
