package org.example;
//made by Jarrett Nobles
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class darkwaterBot {
    private final Dotenv config;
    private final ShardManager shardManager;

    //constructor
    public darkwaterBot()throws LoginException {
        //load .env file
        config = Dotenv.configure().load();
        //get the config for the bot token
        String token=config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("for media in general"));
        builder.build();
        shardManager = builder.build();
        //test commit

    }

    public Dotenv getConfig() {
        return config;
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
