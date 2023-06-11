package cn.bdqn.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="work")
public interface DisplayWorkClient {
}
