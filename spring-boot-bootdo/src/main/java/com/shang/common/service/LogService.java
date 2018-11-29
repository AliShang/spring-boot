package com.shang.common.service;

import com.shang.common.domain.LogDO;
import com.shang.common.domain.PageDO;
import com.shang.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
