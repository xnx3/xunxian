package include;
import include.Module.Browser;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import UI.Main;
import UI.Message;
import UI.SaoHuo;
import UI.SeniorFight;
import UI.Skill;
import action.DaGuaiThread;
import action.LogThread;
import action.SaoHuoThread;
import action.SettledOpenThread;
import action.StateThread;
import action.SystemThread;

import com.jacob.activeX.*;

public class Command {
	//此处为动态数值，在Main时先初始化
	public static Main JForm=null;			//new Main()
	public static SaoHuo JframeSaoHuo=null;	//new SaoHuo()
	public static Message jframeMessage=null;		//提示信息new Message()
	public static Skill JframeSkill=null;		//模拟按键、鼠标设置
	public static SeniorFight JframeSeniorFight=null;			//高级打怪模式的配置
	
//	public static boolean notReg=true;			//免注册模式，true适用于工作室使用，可以不需要注册就能使用！
	public static boolean updateModel=false;		//更新模式，此模式下风物志、宠物壳子、强力诀、通神等若是有其他的没在这里面的，会在logScreen文件夹中截图提取出来
	public static String title="仙人辅助_寻仙自动打怪";
	public static Browser browser=new Browser();		//内置浏览器
	public static String version ="v3.4";			//当前版本
	public static boolean run=false;				//软件运行，点击开始、结束对应的
	public static boolean useDaguai=false;		//是否有使用打怪的权限,根据key分配的唯一识别字符判定自动打怪的权限
	public static boolean autoKaiGu=false;			//水底自动开鼓,根据key分配的唯一识别字符判定自动开鼓的权限
	public static boolean useSaoHuo=false;			//交易自动扫货，是否有使用权限
	public static boolean useSFight=false;		//是否能使用高级打怪功能
	public static boolean bindComputer=false;		//是否绑定电脑，注册码与特定的电脑绑定了
	public static boolean myComputerSoleCode=false;		//我的电脑唯一识别码是否跟注册码匹配，若是匹配，返回true
	public static String lineNotePad= "\r\n";		//存txt文件的换行符
	public static boolean tray=false;			//托盘隐藏模式。false，表示托盘隐藏程序
	public static ActiveXComponent activeDm=null;		//大漠对象
	public static ActiveXComponent activeDb_IE=null;	//大兵浏览器对象
	public static ActiveXComponent activeXinNuo=null;	//信诺自动答题
	public static boolean autoDaTi=false;				//是否出验证码后开启自动答题。注册后根据返回的字符串判断，若成立，则开启
	public static String autoDaTiPasswordString="";	//自动答题密码串。注册后通过网站获取
	public static String autoDaTiUserName="";			//自动答题登陆用户名
	public static String autoDaTiPassword="";			//自动答题登陆密码
	public static String autoDaTiRemain=null;			//自动答题剩余的提分
	public static boolean mainThread=false;	//主打怪线程状态，是否开启
	public static StringBuffer logBuffer=new StringBuffer();	//记录日志，定时保存到日志文件log.txt
	public static int softSetCount=0;			//软件剩余使用次数
	public static int softUseCount=0;			//软件已经使用的次数
	public static Map<String, String> register=new HashMap<String, String>();				//开启时先初始化赋值
	public static int hwnd=0;
	public static String thisFilePath="";
	public static String screenNoteFile="logScreen";		//截图保存的所在目录的文件夹名
	public static boolean bindWindow=false;	//当前是否已经对窗口进行绑定了
	public static int autoXunLuTime=2000;		//自动寻路的时间，M键后自动寻路,实际运行中的数值随Init中的动态初始化
	public static boolean autoXunLuChangeUse=true;		//自动寻路是否自动变化，X坐标自动+1+0
	public static boolean autoTreatUse=false;		//是否开启自动治疗模式，高级打怪模式使用
	public static boolean guaiHeadBmpSBoolean=true;		//是否打指定头像的怪。指定头像（打指定的怪）的话为true
	public static String guaiHeadBmpS = "logo.bmp";		//要打的目标怪的指定头像集
	public static String guaiHeadBmpSBak = "";		//要打的目标怪的指定头像集,备份
	public static boolean screenLog=true;			//是否开启截图日志记录
	public static boolean realtimeRemind=true;	//是否开启实时提醒
	public static boolean emailRemind=false;		//是否开启邮件提醒,只限收费无论哪个，付过钱的用户才能开启
	public static String myEmail="";				//我的email地址，如果上面emailRemind开通了，则发送至这个邮箱地址
	public static boolean emailMoneyNotEnoughFirst=true;	//扫货时钱不够，第一次的时候发送邮件，是否是第一次，默认开启之后便是true第一次，以后发送一次之后变为false
	public static String roleName=null;				//该软件对应的游戏角色名字,用户JFrame的title、邮件发送标题
	public static boolean playMusic=true;		//是否实时播放声音提示
	public static boolean directSet=false;		//小地图方向设置自动匹配是否开启
	public static String playFile="";			//线程播放的声音文件,每次播放重新赋值文件
	public static int playTime=5000;			//播放声音文件的持续时间
	public static int myOverTime=1000000;			//死亡后为了避免被恶意刷死亡，死亡后等待的时间，超过这个时间再继续打
	public static int daguaiMode=1;			//打怪模式，对应DaGuaiFunc.isKilTarget
	public static double dianSim=1.0;			//定点找色统一sim模糊度
	public static int orderDir=1;				//查找顺序，1为从上到下从左到右
	public static String dianColor="202020";	//定点找色统一误差值
	public static double picSim=1.0;			//找图统一模糊度
	public static double picSimBak=1.0;			//找图统一模糊度,备份
	public static String picColor="303030";	//找图统一误差值
	public static Color fontColor_LabelUI=Color.yellow;		//界面文字颜色
	public static boolean overGuard=true;					//guard线程是否对人物死亡(仅死亡)进行监视
	public static int runType=1;					//运行的类型，1为自动打怪，2为自动扫货,系统线程通过此处判断开启相应的线程
	public static boolean readSmallPosition=true;		//是否读取小地图坐标，读取为true，不读取为false
	public static boolean useLookAndFeel=false;		//是否使用lookAndFeel界面外观
	public static int delay=500;					//网络延迟，单位毫秒
	public static String dmComLastCreateTime=null;		//DM-COM创建的时间,每间隔一段时间会重新创建一次COM接口释放内存，记录最后一次创建的COM接口
	public static boolean useOptimizeCpu=false;			//是否开启CPU降频，界面用户自定义
	
	public static int runModel=1;		//打怪运行后，存放选择的daguaiModeArray的当前第几个数据，数组下标模式0开头
	public static int runMap=1;			//打怪运行后，存放选择的daguaiMapArray的当前第几个数据，数组下标模式0开头
	
	/**
	 * www.xnx3.com添加软件后的软件编号,代理更改
	 * 1：我的
	 * 2：伸善网络-总裁 (代理)
	 */
	public static int agent=1;		//新版本代理，输入代理编号
	
	
	public static DaGuaiThread daGuaiThread=null;		//打怪主线程
	public static StateThread stateThread=null;		//定时辅助技能释放线程
	public static LogThread logThread=null;			//日志记录线程
	public static SaoHuoThread saoHuoThread=null;		//自动扫货线程
	public static SettledOpenThread settledOpenThread=null;	//定点开鼓线程
	public static SystemThread systemThread=null;		//系统线程，监控、捕获异常、内存释放处理等
	public static int logThreadSleep=1200000;			//日志线程休眠100分钟
	public static int systemSleep=12000000;			//系统线程，200分钟
	
	//Main.jframe
	public static int[] jComboBoxOptimizeArray={2,6,9,12,18,24};	//单位：小时
	
	
	//一下全部为静态数值，固定
	public static int clientWidth=1024;
	public static int clientHeight=768;
	public static String resource="xnx3";		//资源文件在此文件夹下的哪个文件夹
	
	
	//点坐标、颜色
	//我的血条
	public static int myXueXStart=89;
	public static int myXueY=54;	
	public static int myXueXEnd=236;
	public static String myXueColor="e72b00";
	
	//我的蓝条
	public static int myLanXStart=90;
	public static int myLanY=62;	
	public static int myLanXEnd=236;
	public static String myLanColor="2382ec";
	
	//怪的血条
	public static int guaiXueXStart=280;
	public static int guaiXueY=57;
	public static int guaiXueXEnd=384;		//结束时显示百分数会遮挡，所以最后一段无效
	public static String guaiXueColor="e60000";		//一管血的怪
	public static String guaiXueColor2="e67200";	//两管血的怪
	
	//怪锁定我的血条
	public static int guaiMyXueX=485;
	public static int guaiMyXueY=88;
	public static String guaiMyColor="fc0000|fc7e00";
	
	//怪的头像范围坐标395,25,450,90
	public static int guaiHeadXStart=389;
	public static int guaiHeadYStart=25;
	public static int guaiHeadXEnd=450;
	public static int guaiHeadYEnd=90;
	
	//计算，便于help()帮助函数调用
	public static double myXuePercent=(myXueXEnd - myXueXStart) / 100;
	public static double myLanPercent=(myLanXEnd - myLanXStart) / 100;
	
	
	//双精度浮点数,用于模糊度
	public static double doubleNine=0.9;
	public static double doubleTen=1;

	//颜色误差
	public static String colorErrorOne="101010";
	public static String colorErrorTwo="202020";
	public static String colorErrorThree="383838";
	
	//查询叛军小鼓存在的区域大小
	public static int guXStart=2;
	public static int guYStart=100;
	public static int guXEnd=1016;
	public static int guYEnd=705;
	
	//小地图读取坐标的x坐标读取范围
	public static int mapXPositionXStart=903;
	public static int mapXPositionYStart=79;
	public static int mapXPositionXEnd=933;
	public static int mapXPositionYEnd=89;
	//小地图读取坐标的Y坐标读取范围
	public static int mapYPositionXStart=932;
	public static int mapYPositionYStart=79;
	public static int mapYPositionXEnd=964;
	public static int mapYPositionYEnd=89;
	//小地图判断使用的颜色范围及近似度
	public static String mapPositionColor="d6ddd5-555555";
	public static double mapPositionSim=0.9;
	
	//按键码数组
	public static int[] keyArray = {49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 189, 187, 81, 69, 82, 86, 72, 85, 89, 80};
	//技能释放后选择自定义的延迟时间
	public static int[] keySleep={200, 500, 1000, 2000, 3000};
	//自定义辅助技能选项
	public static int[] helpArray = {10, 20, 30, 40, 50, 60, 70, 80, 90};
	
	/**
	 * [0]:水底-丞相大营
	 * [1]:水底-水草盆地
	 * [2]:求仙镇-三家村
	 * [3]:地府-无根地
	 * [4]:茅山-乱坟岗
	 * [5]:通天河-景阳冈
	 * [6]:舍身台-天书崖
	 * [7]:摩云山-风香原
	 * [8]:摩云山-歌雨滩
	 * [9]:摩云山-灵谷
	 * [10]:摩云山-宸虎观
	 * [12]:用户自定义挂机点的
	 * [13]:高级打怪模式的京城-皇陵道
	 * [14]:高级打怪模式的京城-坑牙洞外围
	 * [15]:高级打怪模式的京城-坑牙洞内
	 * [16]:高级打怪模式的茅山-乱坟岗
	 * [17]:高级打怪模式的茅山-石门西郊
	 * [18]:高级打怪模式的地府-忘川岸
	 * [19]:高级打怪模式的地府-罗浮寨复活点
	 * [20]:高级打怪模式的地府-无根地
	 * [21]:高级打怪模式的摩云山-响石岭-精魄阵
	 * [22]:高级打怪模式的五岳山麓-瓜田
	 * [23]:高级打怪模式的五岳山麓-高老庄
	 * [24]:高级打怪模式的五岳山麓-福陵山
	 * [25]:高级打怪模式的五岳山麓-子午岭
	 * [26]:高级打怪模式的摩云山东部-精魄阵-小怪
	 * [27]:高级打怪模式的摩云山东部-哭风岭
	 * [28]:高级打怪模式的五岳山麓-白云观
	 * [28]:高级打怪模式的五岳山麓-子午岭瓜田
	 */
	//走动打怪的路线.M键打开大地图的Map坐标跟右上方小地图的Position坐标
	//按M键打开的地图，目标点位于窗口的坐标(下标第12的{0,0}为自定义挂机点，动态有用户自己选择。第一个用户自己选择的，第二个坐标为第一个的基础上+3)
	public static int[][] routeMapXArray={{615,636},{217,388},{404,424},{178,194},{357,355},{186,190},{550,555},{148,134},{218,253},{234,196},{140,156},{334,337},{0,0},{262,258,215,197,199,193,226,253,224,228,229},{307,319,328,340,333,325,312},{314,314},{354,370,356},{394,400,388,374,387,390},{281,279,280,296,290,268},{271,279,266,245,236},{228,215,177,160,153,200},{332,332},{351,296,354},{357,375,379},{306,281},{259,296},{295,318,316},{395,382,387},{464,492,494},{273,257}};
	public static int[][] routeMapYArray={{530,385},{612,621},{328,372},{263,289},{492,523},{349,326},{397,385},{370,401},{353,387},{566,588},{590,590},{242,235},{0,0},{292,313,319,321,333,350,363,382,343,331,318},{527,532,530,534,522,528,525},{613,528},{537,503,513},{386,370,360,367,382,371},{421,441,474,455,434,400},{344,328,320,343,356},{313,280,261,247,284,287},{241,242},{347,316,357},{388,406,389},{470,487},{236,312},{270,299,254},{267,251,285},{255,250,236},{320,313}};
	//小地图的具体坐标位置
	public static int[][] targetPositionXArray={{901,937},{356,601},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1},{1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1,1},{1,1},{1,1,1},{1,1,1},{1,1},{1,1},{1,1,1},{1,1,1},{1,1,1},{1,1}};
	public static int[][] targetPositionYArray={{468,665},{356,333},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1},{1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1,1},{1,1},{1,1,1},{1,1,1},{1,1},{1,1},{1,1,1},{1,1,1},{1,1,1},{1,1}};
	//X最小，Y最小，X最大，Y最大
	public static String[][] routePositionLimitArray={{"890|455|913|480","925|652|950|677"},{"342|342|370|370","585|320|615|350"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2","0|0|2|2"},{"0|0|2|2","0|0|2|2"}};
	
	//打怪模式选择
	public static String[] daguaiModeArray={"水底打叛军+开鼓","水底走动只开鼓","普通打怪模式","捉宝宝","交易自动扫货","后台键盘鼠标模拟","水底定点开小鼓","高级打怪模式"};
	//打怪地图,一维对应daguaiModeArray，二维便是其模式下的打怪地图了,二维与上方的地图数据同步！
	public static String[][] daguaiMapArray={{"丞相大营","水草盆地"},{"丞相大营","水草盆地"},{"自定义挂机点","求仙镇-三家村","地府-无根地","茅山-乱坟岗","通天河-景阳冈","舍身台-天书崖","摩云山-风香原","摩云山-歌雨滩","摩云山-灵谷","摩云山-宸虎观","水底只刷钱宁河叛军-丞相大营","水底只刷钱宁河叛军-水草盆地","摩云山-啸风州-精魄阵"},{"后台打符-按123键"},{"整个交易市循环跑动扫货"},{"后台自动模拟键盘鼠标"},{"手动到出鼓点(适用所有鼓)"},{"京城-皇陵道","京城-坑牙洞门口","京城-坑牙洞全洞通道","茅山-乱坟岗","茅山-石门西郊","地府-忘川岸","地府-罗浮寨复活点","地府-无根地","摩云山-响石岭-精魄阵-刷BOSS","五岳山麓-瓜田","五岳山麓-高老庄","五岳山麓-福陵山","五岳山麓-子午岭","摩云山东部-精魄阵-小怪","摩云山东部-哭风岭","五岳山麓-白云观","五岳山麓-子午岭瓜田"}};
	//当前到了第几个地点了，哪个地点，对应上面的数组编号
	public static int[] routeMapX =null;
	public static int[] routeMapY=null;
	public static int[] targetPositionX=null;
	public static int[] targetPositionY=null;
	public static String[] routePositionLimit=null;
	//循环的地点默认坐标位置
	public static int rank=0;
	//循环地点默认的地点个数，从上面自动获取
	public static int rankMax=0;
	//rankMax = UBound(routeMapX)
	//当前是否使用小地图
	public static boolean usePosition = false;
	//记录走的次数,超出指定次数认为地图读取出错，自动切换至下一个地点
	public static int walkRunNum=0;
	//小地图走动时每次走动的时间间隔
	public static int positionMoveTime = 400;
	//最大的走动次数，避免出现读取错误而死循环
	public static int routeMapMax = 80;
	public static int positionMapMax = 20;
	/*
	 * 地图走位完毕
	 */
	
	
	/**
	 * 界面数据设置
	 */
	//打怪技能释放
	public static int jineng1Key=49;	//技能1按键码
	public static int jineng1Time=800;	//技能1按下后等待的时间
	public static int jineng2Key=50;
	public static int jineng2Time=800;
	public static int jineng3Key=51;
	public static int jineng3Time=800;
	
	
	public static int helpHongNum=6;		//救援技能设置,对应helpArray数组,当前血量少于，则喝红
	public static int helpHongKey=10;		//按键，对应keyArray,使用时为keyArray[10]
	public static int helpHongTime=2;		//技能释放后等待时间,对应jiNengSleep
	public static boolean helpLanUse=true;	//为了力士职业存在，是否需要喝蓝
	public static boolean helpHongUse=true;	//考虑到自动扫货的存在，可选择是否喝红跟回生水
	public static int helpLanNum=4;
	public static int helpLanKey=11;
	public static int helpLanTime=1;
	public static int helpHuiShengShuiNum=5;
	public static int helpHuiShengShuiKey=8;
	public static int helpHuiShengShuiTime=1;
	
	//以下须初始化覆盖属性
	public static boolean helpJiNeng1Use=true;	//开启
	public static int helpJiNeng1Num=8;			//当血量少于百分之多少时(90%)
	public static int helpJiNeng1Key=4;			//5键	对应keyArray数组中的数据	
	public static int helpJiNeng1Time=1;			//技能释放时间，对应keySleep数组中的数据		
	public static boolean helpJiNeng2Use=true;	//开启
	public static int helpJiNeng2Num=1;			//20%
	public static int helpJiNeng2Key=5;			//6键
	public static int helpJiNeng2Time=1;
	
	//多线程定时技能释放，选择职业时启动后初始化
	public static int threadJiNengKey=3;		//4键
	public static int threadJiNengSleep=1000;	//辅助技能释放时间
	public static int threadJiNengTime=300000;	//多长时间释放一次(3分钟)
	
	//Z键一键拾取的时间
	public static int zTime=2000;		//Z键一键拾取时间，初始化
	
	
	/*
	 * 自动扫货初始化数据，若是自动加载外部配置数据出错，则加载此处的默认数据
	 */
	public static String saoHuoInitGroceriesDataName[]={"侍宠玩具","秘法结晶","幽寒淬炼石碎片","炽炎淬炼石碎片","紫晶云母","妖怪黄历","空白符纸","炽炎淬炼石","玫瑰花","气之精","五彩灵石碎片","聚灵晶（小）","灵虚精髓","太乙珠","绿山辉石","侍宠炼化符","骑宠炼化符","坤灵寒玉","天罡破界石","骑宠玩具","巫术结晶","精之晶","白色魂玉","绿色魂玉","朴素的戒指","附魂石","火力之石","定魂石","1-5级战魂","7-9级战魂","仙兽骑宠蛋","强力诀至尊属性"};//,
	public static int saoHuoInitGroceriesDataValue[]={20002,30002,400002,50002,1002,502,502,500002,50002,50002,25002,20002,50002,20002,5002,30002,30002,1002,1000002,20002,2002,150002,30002,80002,502,100002,1002,400002,30002,1000002,1000002,1000002};			//价格，单位为铜,对应上面的数据,  ,30002,1000002
	public static Map<String, Integer> saoHuoInitGroceriesDataMap=new data.Groceries().groceriesBak();
	
	/**
	 * 自动扫货数据，外部加载的数据，最新数据，扫货时使用此处的数据
	 */
	public static Map<String, Integer> saoHuoGroceriesDataMap=new data.Groceries().groceriesBak();
	
	public static int saoHuoGroceriesColumn=3;				//数据的列数
	
	//自动扫货的大地图坐标走位{装备区,南门,材料区,东门,宠物区,北门,杂货区,西门,西擂台,南擂台,东擂台,北擂台}
	public static int[] saoHuoMapXArray={346,436,543,572,536,437,342,303,391,436,481,438};
	public static int[] saoHuoMapYArray={493,542,495,396,293,246,295,395,391,438,393,351};
	public static int saoHuoNowPosition=0;			//对应上面数组的坐标,0为装备区
	public static boolean saoHuoOneTongScanUse=true;		//是否扫描1铜物品是否开启
	
	public static boolean saoHuoGroceriesUse=true;				//扫货时杂货类扫描是否开启
	public static Map<String, Integer> saoHuoGroceries=new HashMap<String, Integer>();		//杂货类扫货数据放置
	
	public static boolean saoHuoStoneUse=true;	//扫货时八卦灵石扫描是否开启
	public static Map<String, Integer> saoHuoStone=new HashMap<String, Integer>();		//格式为saoHuoStone.put("完美乾卦力量之石",200002);
	
	public static boolean saoHuoPetUse=true;		//扫货时宠物壳子扫描是否开启
	public static Map<String, Integer> saoHuoPet=new HashMap<String, Integer>();		//格式为saoHuoPet.put("莹彩蝴蝶",200002);
	
	public static boolean saoHuoFengWuZhiUse=true;				//扫货时风物志类扫描是否开启
	public static Map<String, Integer> saoHuoFengWuZhi=new HashMap<String, Integer>();		//风物志类扫货数据放置
	
	public static boolean saoHuoLegendUse=true;				//扫货时传奇配方类扫描是否开启
	public static Map<String, Integer> saoHuoLegend=new HashMap<String, Integer>();		//传奇配方类扫货数据放置
	
	public static Map<String, Integer> saoHuoElseClass=new HashMap<String, Integer>();		//其他小类的扫货数据放置
	public static boolean saoHuoQiangLiJueUse=true;				//强力诀扫描是否开启
	public static boolean saoHuoTongShenJueUse=true;				//通神诀扫描是否开启
	public static boolean saoHuoZhanHunUse=true;				//战魂水晶扫描是否开启
	
	/**
	 * Skill.form
	 */
	public static int[] skillJcomboboxUse={0,0,0,0,0};	//数组中表示是否使用，存放jcombobox?Use的结果,动态数据
	public static int[][] skillSetData={{0,0},{0,0},{0,0},{0,0},{0,0}};	//设置的数据,若是设置的使用鼠标则为{x,y}坐标，若是按键则为{按键码,?}
	public static int[] skillTime={100,100,100,100,100};	//同上，释放之后的延迟时间
	
	/**
	 * SeniorFight.form
	 */
	public static boolean autoXiuLi=false;		//是否开启发现装备要修理时自动修理装备
	public static boolean xiuLi_UseMenPai=false;	//是否使用门派的修理，若是为false，则使用地图内的修理
	public static boolean autoEmptyParcel=false;		//修理装备时，是否自动清空包裹
	public static boolean useLanAnswer=false;		//是否开启了局域网答题,开启了之后，答题时先从此判断，若是局域网发送失败（目标电脑没开启）则转向用信诺答题
	public static String faqSendPort="12345";		//DM内置的答题发送至服务器的端口号
	public static String serverIP="";		//发送至的服务器IP，动态由界面加载
	//使用局域网答题器的使用时间段
	public static int hoursStart=0;		//开始的小时
	public static int hoursEnd=0;	
	public static boolean useLanIpIsOnline=false;	//是否开启智能判断，在指定的答题时间段智能判断IP是否在线，不在线则使用信诺答题，在线使用局域网答题
	
	
	/***************************************************/
	/**
	 * 获取软件标题
	 * @return
	 */
	public static String getTitle(){
		switch(agent){
			case 1:		//1是自己的
				return Command.title;
			case 2:
				return title+"_伸善网络";
			default:
				return Command.title;
		}
	}
	
	/**
	 * 注册时的接口网址，后面的&key=***已经程序内写上
	 * @return
	 */
	public static String getRegApiUrl(){
		switch(agent){
		case 1:		//1是自己的
			return "http://www.xnx3.com/e/extend/SoftKey/CheckKey.php?cid=11";
		case 2:
			return "http://www.xnx3.com/shenshan/e/extend/softKey/CheckKey.php?cid=2";
		default:
			return "http://www.xnx3.com/e/extend/SoftKey/CheckKey.php?cid=11";
		}
	}
	
	
	
}
