package cn.test.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//������������
		JobDetail detail=context.getJobDetail();
       	//��ȡ����������
		String name=detail.getJobDataMap().getString("name");
      	String job=detail.getKey().getGroup();
       	System.out.println("������ȣ��飺"+job+",��������"+name+"---->�����������������ݴ����");
	}

}
