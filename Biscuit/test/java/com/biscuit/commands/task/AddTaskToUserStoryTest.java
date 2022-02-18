/*
 * package com.biscuit.commands.task;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import java.io.IOException;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import org.mockito.InjectMocks; import
 * org.mockito.Mockito; import org.mockito.runners.MockitoJUnitRunner;
 * 
 * import com.biscuit.models.Project; import com.biscuit.models.UserStory;
 * 
 * @RunWith(MockitoJUnitRunner.class) public class AddTaskToUserStoryTest{
 * 
 * @InjectMocks AddTaskToUserStory addTaskToUserStory;
 * 
 * UserStory userStory = null; Project p= null;
 * 
 * 
 * //@Before public void init(){ userStory= new UserStory(); userStory.title=
 * "JUnit1"; userStory.description="Description 1";
 * 
 * p = new Project(); p.backlog.addUserStory(userStory); }
 * 
 * //@Test public void executeTest() throws IOException {
 * //addTaskToUserStory=new AddTaskToUserStory(reader, userStory.project,
 * userStory); AddTaskToUserStory addTaskToUserStorySpy =
 * Mockito.spy(addTaskToUserStory);
 * 
 * 
 * //Mockito.doNothing().when(addTaskToUserStorySpy).setTitlePublicMethod();
 * //Mockito.doNothing().when(addTaskToUserStorySpy).setTitlePublicMethod();
 * //Mockito.doNothing().when(addTaskToUserStorySpy).setTitlePublicMethod();
 * 
 * 
 * //addTaskToUserStory= new AddTaskToUserStory(reader, userStory.project,
 * userStory); boolean saved=addTaskToUserStory.execute(); assertEquals(true,
 * saved);
 * 
 * }
 * 
 * }
 */