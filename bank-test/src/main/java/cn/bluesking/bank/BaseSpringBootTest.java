package cn.bluesking.bank;

import cn.bluesking.bank.listener.SqlScriptTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

/**
 * 提供给其他包使用的 SpringBoot 单元测试基础类对象，同时也在此处注册了自定义的 TestExecutionListener。
 *
 * @author 随心
 * @date 2020/8/2
 */
@SpringBootTest
@TestExecutionListeners(
        listeners = {SqlScriptTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class BaseSpringBootTest {
}
