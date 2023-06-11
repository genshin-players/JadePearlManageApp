package cn.bdqn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZedFeorius
 * @version 1.0.0
 * @date 06 11 2023  17:30:37
 * @packageName cn.bdqn.client
 * @className DisplayClient
 * @describe TODO
 */
@FeignClient(name = "display")
public interface DisplayClient {

}
