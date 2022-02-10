package com.biscuit.commands.externalServices;

import com.biscuit.ColorCodes;
import com.biscuit.models.Dashboard;
import com.biscuit.models.Project;
import com.biscuit.views.DashboardView;
import com.slack.api.Slack;
import com.slack.api.SlackConfig;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import jline.console.ConsoleReader;

import java.io.IOException;

public class ConnectSlack {

    private String slackToken;
    private String slackChannelName;

    private static SlackConfig slackConfig;
    private static MethodsClient methodsClient;
    private static Slack slack;

    private final String MSG_CONNECTION_INITIALIZATION = "This Slack channel is now connected with Biscuit.";

    public ConnectSlack (String slackToken, String slackChannelName)
    {
        this.slackToken = slackToken;
        this.slackChannelName = slackChannelName;
    }

    public ConnectSlack() {
        this.slackToken = new String ("");
        this.slackChannelName = new String ("");
    }

    public static boolean sendSlackMessage (String slackChannelName, String slackToken, String messageToBeSent)
    {
        try {
            slackConfig = new SlackConfig();
            slackConfig.setPrettyResponseLoggingEnabled(true);
            slack = Slack.getInstance(slackConfig);
            methodsClient = slack.methods(slackToken);



            ChatPostMessageRequest chatPostMessageRequest = ChatPostMessageRequest.builder().channel(slackChannelName).text(messageToBeSent).build();
            ChatPostMessageResponse chatPostMessageResponse = methodsClient.chatPostMessage(chatPostMessageRequest);

            if (chatPostMessageResponse.isOk()) {
                //If 'ok' is true, then response is success.
                return true;
            }
        }
        catch (Exception exception) {

        }
        return false;



    }

    public boolean validateSlackInformation ()
    {
        try {
            if (slackToken != null & slackChannelName != null) {

                boolean isSlackInformationValid = sendSlackMessage(slackChannelName, slackToken,MSG_CONNECTION_INITIALIZATION);

                if(isSlackInformationValid)
                {
                    //If 'ok' is true, then response is success.
                    return true;
                }

            }
        }
        catch (Exception exception) {
            //Does have to do anything since method is already returning 'false'
        }
        return false;

    }

    //Function to add Slack information
    public static void addSlackInformationToProject (Project project, ConsoleReader reader) throws IOException {

        String line;
        reader.setPrompt(ColorCodes.BLUE + "Do you want to connect with Slack channel? [Y] Yes \t [N] No:" + ColorCodes.RESET);
        line = reader.readLine();
        if (line.equals("Y")) {

            boolean isSlackConnectionEstablished = false;
            int totalAttemptsToValidateSlackConnection = 5;
            String userInputSlackChannelName ="", userInputSlackToken="";

            do {
                reader.setPrompt(ColorCodes.BLUE + "Slack channel name:" + ColorCodes.RESET);
                userInputSlackChannelName = reader.readLine();

                reader.setPrompt(ColorCodes.BLUE + "Slack token:" + ColorCodes.RESET);
                userInputSlackToken = reader.readLine();

                ConnectSlack connectSlack = new ConnectSlack(userInputSlackToken, userInputSlackChannelName);
                isSlackConnectionEstablished = connectSlack.validateSlackInformation();

                totalAttemptsToValidateSlackConnection--;


            } while (isSlackConnectionEstablished != true & totalAttemptsToValidateSlackConnection > 0);

            if (isSlackConnectionEstablished == true) {
                project.setSlackToken(userInputSlackToken);
                project.setSlackChannelName(userInputSlackChannelName);
            }
        }
    }

    public String getSlackToken() {
        return slackToken;
    }

    public void setSlackToken(String slackToken) {
        this.slackToken = slackToken;
    }

    public String getSlackChannelName() {
        return slackChannelName;
    }

    public void setSlackChannelName(String slackChannelName) {
        this.slackChannelName = slackChannelName;
    }



    //    private static ConnectSlack connectSlack = null;
//
//    private String slackToken;
//    private String slackChannelName;
//
//    private ConnectSlack () {
//
//    }
//
//    // Static method to create an instance of Singleton class ConnectSlack
//    private static ConnectSlack getInstance(String slackToken, String slackChannelName) {
//
//        SlackConfig sc = new SlackConfig();
//        sc.setPrettyResponseLoggingEnabled(true);
//
//        if(connectSlack == null) {
//            connectSlack = new ConnectSlack();
//            connectSlack.slackToken = slackToken;
//            connectSlack.slackChannelName = slackChannelName;
//        }
//
//        return connectSlack;
//
//    }
//
//    public static void main (String [] args)
//    {
//        SlackConfig sc = new SlackConfig();
//        sc.setPrettyResponseLoggingEnabled(true);
//
//
//        Slack s = Slack.getInstance(sc);
//
//        String slackToken = "xoxb-3077743010642-3077805909427-c5JzGbMORPZejDRiz2nYRnk1";
//        String slackChannelURL = "https://app.slack.com/client/T0329MV0AJW/C0326QRR9NH";
//        String slackChannel = "#2";
//        MethodsClient mc = s.methods(slackToken);
//
//
//        String randomText = String.valueOf(System.currentTimeMillis());
//        System.out.println("RandomText: "+randomText);
//        ChatPostMessageRequest cpmr = ChatPostMessageRequest.builder().channel(slackChannel).text(randomText).build();
//
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("enter an integer");
//        int myint = keyboard.nextInt();
//
//        while(myint!=0) {
//
//            myint = keyboard.nextInt();
//            try {
//
//                cpmr = ChatPostMessageRequest.builder().channel(slackChannel).text(String.valueOf(myint)).build();
//                ChatPostMessageResponse cpmResponse = mc.chatPostMessage(cpmr);
//                System.out.println("Response is ");
//                System.out.println(cpmResponse);
//            } catch (Exception e) {
//
//            }
//
//        }
//
//    }

}
