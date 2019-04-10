package cn.test.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//创建工作详情
		JobDetail detail=context.getJobDetail();
       	//获取工作的名称
		String name=detail.getJobDataMap().getString("name");
      	String job=detail.getKey().getGroup();
       	System.out.println("任务调度：组："+job+",工作名："+name+"---->今日整点抢购，不容错过！");
	}

}
