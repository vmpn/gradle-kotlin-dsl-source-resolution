import java.nio.file.Paths;

import org.gradle.tooling.BuildAction;
import org.gradle.tooling.BuildController;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.gradle.tooling.model.build.BuildEnvironment;

public class RunTool {

  public static void main(String... args)
  {
    final var projFolder = args[0];
    ProjectConnection connection = GradleConnector.newConnector()
      .forProjectDirectory(Paths.get(projFolder).toFile())
      .connect();
    
    try 
    {
//    	connection.model(BuildEnvironment.class).get();
    	connection.action(new BuildAction<String>() {

			@Override
			public String execute(BuildController controller) {
				controller.getBuildModel();
				return "";
			}
    		
		});
    }
    finally
    {
    	connection.close();
    	
    }
  }
}
