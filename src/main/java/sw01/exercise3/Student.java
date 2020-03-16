/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw01.exercise3;

/**
 *
 * @author yannk
 */
public class Student extends Person {
    public static final int SKILL_NEEDED_FOR_BACHELOR = 40;
    
    public boolean hasFinishedBachelor;
    
    public int numberOfSemestersStartedInUniversity;
    
    private int skill;
    
    public Student(String name) {
        super(name);
        this.hasFinishedBachelor = false;
        this.numberOfSemestersStartedInUniversity = 1;
        this.skill = 0;
    }
    
    public int getSkill() {
        return this.skill;
    }
    
    public void setSkill(int newSkill) {
        this.skill += newSkill;
        if (this.skill >= Student.SKILL_NEEDED_FOR_BACHELOR) {
            this.hasFinishedBachelor = true;
        }
    }
    
    public int amountPaidForBachelorInCentime() {
        return 20000 + 80000 * this.numberOfSemestersStartedInUniversity;
    }
    
    public void doHomework() {
        // improves skill
        this.setSkill(1);
    }       
}
