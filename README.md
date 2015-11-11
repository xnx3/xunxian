说明简介：  
用Java语言，为“新寻仙”网游写的一款辅助工具，主要功能为自动打怪、交易自动扫货，附属一些键盘连按、鼠标连点、等等小功能。  
用Java实现Windows平台下的模拟鼠标、按键、找图找色，实现按键精灵的功能。 


目录简介：  
/else information         --> 其他说明，包括注册dll、利润说明、使用说明等等,属于附加说明。  
/jre7                     --> 运行环境,运行、调试时，请使用此Jre来运行，否则很可能会出莫名其妙错误  
/xunxianAutoFight         --> Java Project ，可直接导入MyEclipse  
/xunxianAutoFight/config  --> 软件的配置项，如界面数据保存、自动扫货买东西设置的一些金额保存等  
/xunxianAutoFight/xnx3    --> 资源文件，找图、点阵读字的文件存放  
/xunxianAutoFight/src     --> Java源码  
/xunxianAutoFight/src/Main.java --> 运行程序的入口文件，运行程序时运行此文件。  
/xunxianAutoFight/src/include/Command.java  --> 整体控制，软件的数据配置、缓存等都是在这里，其他具体的参数等可以查看这个文件。  
  
开发步骤：  
1.先进/else information/  将两个.bat文件全部执行一遍  
2.将/xunxianAutoFight 导入项目 Eclipse（推荐使用MyEclpse 8.5，因为界面是用的这个画的），以 Java Project 导入  
3.运行 /xunxianAutoFight/src/Main.java  查看效果  
  
  
其他说明：  
软件含客户端（这个）、服务端注册控制（PHP＋Mysql）、自动购买开号（PHP＋Mysql）。目前只发布此软件客户端，不用于商业用途下已等于全部开源共享发布！到目前2015.4.20日来看，除了水下开故停止更新作废外，其余功能完全正常使用！ 
  
本人于10年开始用按键精灵写寻仙辅助  
11年开始转向于用Java编写，全部自己使用，最好的时候当属刷九蛇斜眼、金鳞  
13年软件对外发布  
15年，源码共享！由于种种原因，已不玩寻仙，一个月上不了一次，已退出寻仙，故发布！  
  
软件使用MyEclipse8.5编写，其中的UI界面也是用的IDE的工具拖拽而成。在毕业后而做，而后一直在上修改，到目前来看已显粗糙。 
于15年整理了一个Java用于Windows辅助工具开发的第三方Jar包：xnx3.jar，将用到的东西都整理了一番。有详细的开发文档。  
是从前5年编写整理出来的代码。当然，这个jar包在辅助源码里是不存在的，辅助已于14年10月份发布3.4版本后就已停止更新。 
技术讨论地址java.xnx3.com，交流QQ群418768360，仅限Java开发者加入讨论交流技术！  
  
作者：管雷鸣  
业务联系QQ：921153866 
打包出的运行软件预览下载：http://www.xnx3.com/xunxian/fuzhu/down.html 
【源码已免费发布，有问题自行加群交流，不提供任何免费解答~~~不可用于非法用途，否则任何后果与本人无关~】  
  
