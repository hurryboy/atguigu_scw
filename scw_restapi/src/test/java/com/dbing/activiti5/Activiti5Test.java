package com.dbing.activiti5;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * author:dbing
 *
 * 测试工作流程activiti5 框架
 *
 */
public class Activiti5Test {

    //创建一个默认的流程引擎，它是线程安全的，所以直接作为全局变量
    //ProcessEngine processEngine=ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    public void testCreateEngine(){
        System.out.println(processEngine);
    }

    /**
     * 利用插件actiBPM创建流程图
     * 部署流程图（保存到数据库中）
     */
    @Test
    public void testDeploy(){

        //1.获取流程服务组件 RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //2.部署流程图
        //同一个流程部署多次，版本迭代。
        repositoryService.createDeployment()//返回流程部署对象
                .addClasspathResource("activiti5/vacationRequest.bpmn")//加载资源文件
                .deploy();
    }

    /**
     * repositoryService查询指定条件的deployment和processDef
     *    xxsService.createxxxQuery()
     *      .条件().条件2()
     *      .[list()、singleResult()、listPage()、count()]
     */
    @Test
    public void testDeployAndProcessDefQuery(){
        RepositoryService service = processEngine.getRepositoryService();
        //查询指定的部署
        DeploymentQuery deploymentQuery = service.createDeploymentQuery();
        Deployment deployment = deploymentQuery.deploymentId("1").singleResult();
        System.out.println(deployment.getDeploymentTime());


        //查询流程定义
        List<ProcessDefinition> list = service.createProcessDefinitionQuery().processDefinitionKey("myProcess_1").list();
        for (ProcessDefinition processDefinition:list){
            System.out.println(processDefinition);
        }
    }

    /**
     * 启动一个流程
     * 场景：启动最新版的流程
     */
    @Test
    public void testRunTimeService(){
        //获取最新版的流程
        RepositoryService RService = processEngine.getRepositoryService();
        ProcessDefinition latestProcessDef = RService.createProcessDefinitionQuery().
                processDefinitionKey("myProcess_1")
                .latestVersion()
                .singleResult();
        System.out.println("最新版的myProcess_1流程图："+latestProcessDef);


        //2.启动最新版的流程（创建流程定义的实例）
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //一个流程定义可以创建对应的多个流程实例
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(latestProcessDef.getKey());
        System.out.println("启动的流程实例："+instance);
    }


    /**
     * 查询指定流程实例的正在运行的任务
     */
    @Test
    public void testQueryTaskRunning(){

        TaskService taskService = processEngine.getTaskService();
        List<Task> lsit = taskService.createTaskQuery().processInstanceId("10001").list();
        for(Task task:lsit){
            System.out.println("当前id为10001的流程实例正在运行的任务:"+task.getName());
            taskService.claim(task.getId(),"admin");
            System.out.println("admin签收任务:10001"+task.getName());
        }

    }

    /**
     * 查询某人分配的任务
     */
    @Test
    public void testQueryTaskByUSer(){
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().taskAssignee("admin").list();
        for(Task task:list){
            System.out.println("分配给admin的任务："+task.getName());
            taskService.complete(task.getId());
            //			taskService.unclaim(task.getId());
//			System.out.println("撤销任务的签收...");
            System.out.println("admin完成任务："+task.getName());
        }
    }


    @Test
    public void testHistoryService(){
        HistoryService service = processEngine.getHistoryService();
        //查询所有已经完成的流程实例
        List<HistoricProcessInstance> list = service.createHistoricProcessInstanceQuery().finished().list();
        String proIdInstance = "";
        for (HistoricProcessInstance historicProcessInstance:list){
            proIdInstance = historicProcessInstance.getId();
            //查询所有结束的流程实例中都完成了什么任务
            List<HistoricTaskInstance> taskList = service.createHistoricTaskInstanceQuery().processInstanceId(proIdInstance).finished().list();
            System.out.println("完成的流程实例："+historicProcessInstance.getName());
            for (HistoricTaskInstance task:taskList){
                System.out.println("该流程实例中完成的任务有："+task.getName());
            }
        }

    }




}
