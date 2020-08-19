package cn.bluesking.bank.listener;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * SQL 脚本执行监听器。
 *
 * @author 随心
 * @date 2020/8/2
 */
@Slf4j
public class SqlScriptTestExecutionListener extends AbstractTestExecutionListener {

    @Override
    public int getOrder() {
        return 5001;
    }

//    private String[] getScripts(Sql sql) {
//        String[] scripts = sql.scripts();
//        
//        return null;
//    }
    
    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        logger.debug("=========== before test class");
        super.beforeTestClass(testContext);
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        logger.debug("=========== after test class");
        super.afterTestClass(testContext);
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        logger.debug("---------- before test method");
        super.beforeTestMethod(testContext);
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        logger.debug("---------- after test method");
        super.afterTestMethod(testContext);
    }

}
