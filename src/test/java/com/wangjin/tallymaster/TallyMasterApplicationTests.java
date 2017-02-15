package com.wangjin.tallymaster;

import com.wangjin.tallymaster.domain.Module;
import com.wangjin.tallymaster.domain.ModuleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TallyMasterApplicationTests {

	@Autowired
	private ModuleRepository moduleRepository;

	@Test
	public void contextLoads() {
        Module module = new Module();
        module.setModuleName("模块管理");
        module.setModuleOrder(1);
        moduleRepository.save(module);
	}

}
