package cn.test.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public static void main(String [] args){

        try{
            //��Factory�л�ȡSchedulerʵ��	
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //����һ��Trigger
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") //����name/group
                .startNow()//һ������scheduler��������Ч
                .withSchedule(SimpleScheduleBuilder.simpleSchedule() //ʹ��SimpleTrigger
                    .withIntervalInSeconds(1) //ÿ��һ��ִ��һ��
                    .repeatForever()) //һֱִ�У����ڵ��ϲ�ͣЪ
                .build();

            //����һ��JobDetail
            JobDetail job = JobBuilder.newJob(HelloJob.class) //����Job��ΪHelloQuartz�࣬����������ִ���߼�����
                .withIdentity("job1", "group1") //����name/group
                .usingJobData("name", "quartz") //��������
                .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
            //Ȼ��ʼ��
            scheduler.start();
            //scheduler.shutdown();

        } catch(SchedulerException se){
            se.printStackTrace();
        }
    }
}
