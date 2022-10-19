package org.example;
//made by Jarrett Nobles
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class darkwaterBot {

    private final ShardManager shardManager;

    //constructor
    public darkwaterBot()throws LoginException {
        String token = "TEST_TOKEN";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("for media in general"));
        builder.build();
        shardManager = builder.build();

    }

    public ShardManager getShardManager(){
        return shardManager;
    }

    //main method
    public static void main(String[] args){
        try {
            darkwaterBot bot = new darkwaterBot();
        }
        catch(LoginException e){
            System.out.println("Error: BOT TOKEN IS INVALID");
        }

    }
}
