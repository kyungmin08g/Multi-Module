package kyungmin.multimodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "kyungmin.multimodule", "kyungmin.core" })
public class MultiModuleApplication {
  public static void main(String[] args) {
    SpringApplication.run(MultiModuleApplication.class, args);
  }
}
