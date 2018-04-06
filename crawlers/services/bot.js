process.env["NTBA_FIX_319"] = 1;
const req = require("request");
const ch = require("cheerio");
const TelegramBot = require("node-telegram-bot-api");
const token = "565532674:AAHfAztpNi7GzarUSuSvbb-eUnKCsOZVOZU";
const bot = new TelegramBot(token, { polling: true });

bot.onText(/\/NadaPraFazer (.*)/, (msg, match) => {
    var id = msg.chat.id;
    var array = match[1].split(';');
    
    for (let i = 0; i < array.length; i++) {
        var url = "https://www.reddit.com/r/" + array[i];
        req(url, (err, resp, body) => {
            var $ = ch.load(body);
            $("div#siteTable > div.link").each(async function () {
                var subReddit = $(this).attr("data-subreddit");
                var title = $(this).find("p.title a.title").text().trim();
                var upVotes = $(this).attr("data-score");
                var linkThread = $(this).find("p.title  > a").attr("href");
                var linksComments = $(this).find("a.bylink.comments.may-blank").attr("href");
                
                if(upVotes >= 5000){
                    var result = "SubReddit: " + subReddit + "\n" + 
                    "Title: " + title + "\n" + 
                    "Up votes: " + upVotes + "\n" +
                    "Link Thread: " + linkThread + "\n" +
                    "Links Comments: " + linksComments;

                    bot.sendMessage(id, result);
                }
            });   
        });
    }
});