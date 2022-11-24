import java.util.*;
import java.lang.reflect.Array;

interface Sorter<T extends Comparable<T>> {

	void sort(T[] items);

	int iterations = 500;
	BubbleSortWhileNeeded whileNeeded = new BubbleSortWhileNeeded();
	BubbleSortUntilNoChange untilNoChange = new BubbleSortUntilNoChange();
	BubbleSortPassPerItem passPerItem = new BubbleSortPassPerItem();

	public static void main(String[] args) {
		//100 elements array of integers
		Integer[] ordered_integers_100 = new Integer[100];
		Integer[] reverse_integers_100 = new Integer[100];
	
		for(int i = 0; i < 100; i++){
			ordered_integers_100[i] = i;
		}
		Integer[] random_integers_100 = {21, 106, 68, 158, 51, 48, 148, 90, 38, 144, 199, 121, 52, 14, 166, 217, 248, 250, 164, 245, 165, 143, 249, 232, 208, 94, 23, 169, 212, 192, 86, 250, 35, 208, 47, 170, 58, 80, 200, 168, 47, 161, 238, 123, 97, 181, 111, 200, 125, 99, 66, 47, 189, 88, 21, 115, 109, 198, 104, 238, 36, 198, 235, 100, 82, 135, 129, 108, 66, 110, 210, 26, 74, 244, 54, 159, 35, 193, 99, 108, 95, 107, 198, 145, 1, 86, 20, 185, 92, 70, 73, 242, 138, 28, 177, 87, 35, 79, 176, 38};
		
		for(int i = 99; i >= 0 ; i--){
			reverse_integers_100[i] = i;
		}
		
		//1000 elements array of integers
		Integer[] ordered_integers_1000 = new Integer[1000];
		Integer[] reverse_integers_1000 = new Integer[1000];
	
		for(int i = 0; i < 1000; i++){
			ordered_integers_1000[i] = i;
		}
		Integer[] random_integers_1000 = {136, 189, 169, 160, 213, 137, 34, 11, 124, 73, 119, 96, 102, 117, 42, 216, 89, 61, 90, 170, 244, 159, 3, 8, 248, 144, 210, 87, 0, 16, 51, 51, 210, 89, 108, 234, 153, 141, 132, 156, 127, 80, 216, 221, 227, 10, 205, 201, 176, 189, 27, 35, 91, 112, 83, 192, 146, 152, 5, 224, 246, 241, 74, 95, 1, 129, 209, 18, 202, 170, 238, 138, 14, 148, 184, 90, 1, 90, 76, 186, 253, 200, 179, 91, 169, 125, 102, 237, 96, 90, 241, 254, 110, 83, 31, 156, 70, 238, 148, 177, 28, 147, 115, 84, 155, 95, 157, 49, 72, 86, 141, 203, 139, 196, 117, 137, 116, 207, 26, 255, 151, 87, 128, 141, 97, 17, 215, 41, 44, 212, 183, 23, 229, 28, 222, 72, 93, 68, 85, 53, 197, 230, 170, 24, 4, 246, 142, 101, 194, 1, 8, 122, 255, 169, 92, 136, 57, 18, 126, 137, 19, 119, 193, 43, 91, 33, 28, 252, 215, 16, 120, 152, 198, 46, 94, 239, 161, 28, 133, 226, 49, 116, 72, 75, 251, 177, 69, 130, 127, 250, 184, 188, 240, 171, 24, 5, 212, 138, 149, 255, 109, 55, 114, 230, 192, 108, 223, 233, 96, 140, 169, 255, 73, 66, 26, 82, 66, 116, 130, 97, 41, 42, 201, 78, 74, 112, 139, 43, 226, 85, 203, 179, 67, 46, 104, 27, 125, 5, 95, 88, 65, 204, 196, 237, 133, 103, 71, 251, 72, 166, 191, 221, 249, 240, 50, 221, 8, 33, 109, 210, 116, 107, 243, 118, 77, 133, 47, 199, 5, 113, 41, 109, 173, 56, 211, 88, 160, 169, 178, 204, 220, 249, 2, 183, 105, 179, 106, 64, 161, 84, 104, 83, 53, 61, 112, 32, 215, 191, 51, 236, 233, 82, 145, 40, 158, 173, 202, 132, 138, 9, 144, 9, 16, 115, 105, 57, 51, 112, 168, 153, 78, 0, 203, 232, 236, 59, 127, 60, 25, 117, 231, 213, 202, 171, 60, 226, 6, 228, 35, 252, 69, 46, 74, 34, 30, 237, 70, 196, 105, 122, 255, 137, 25, 4, 61, 83, 224, 62, 155, 104, 248, 57, 90, 2, 234, 134, 109, 19, 42, 19, 88, 190, 110, 2, 73, 23, 81, 146, 213, 48, 85, 203, 27, 242, 253, 229, 246, 72, 120, 243, 135, 24, 150, 145, 199, 254, 15, 23, 169, 133, 209, 113, 99, 105, 90, 3, 69, 118, 15, 102, 56, 113, 121, 39, 120, 31, 42, 75, 224, 20, 237, 151, 72, 159, 169, 178, 119, 32, 236, 128, 47, 14, 117, 78, 179, 191, 3, 170, 177, 205, 17, 185, 203, 168, 35, 48, 162, 165, 167, 143, 224, 152, 82, 189, 107, 178, 224, 7, 171, 123, 7, 147, 122, 82, 156, 57, 127, 160, 103, 33, 162, 206, 253, 188, 4, 56, 118, 205, 182, 216, 73, 29, 205, 82, 200, 237, 227, 225, 16, 98, 224, 46, 194, 27, 19, 158, 51, 82, 90, 117, 246, 140, 229, 13, 73, 196, 118, 50, 158, 150, 126, 215, 222, 0, 237, 231, 243, 158, 26, 237, 241, 109, 37, 248, 41, 231, 165, 127, 201, 70, 174, 224, 106, 168, 223, 244, 106, 124, 15, 20, 248, 240, 53, 99, 143, 2, 48, 93, 29, 254, 26, 15, 158, 237, 35, 146, 207, 231, 147, 166, 94, 102, 189, 146, 93, 231, 109, 157, 194, 40, 12, 76, 111, 123, 73, 66, 54, 4, 132, 240, 241, 88, 141, 86, 220, 216, 175, 30, 192, 17, 127, 221, 64, 113, 19, 128, 71, 231, 81, 105, 14, 142, 107, 223, 155, 94, 148, 81, 142, 21, 56, 46, 39, 48, 216, 41, 159, 253, 13, 99, 87, 39, 192, 60, 199, 169, 141, 160, 172, 152, 153, 84, 191, 242, 149, 98, 211, 237, 63, 182, 234, 144, 96, 1, 161, 174, 184, 217, 4, 6, 71, 34, 43, 17, 162, 156, 183, 74, 188, 243, 168, 255, 252, 54, 138, 72, 128, 77, 177, 154, 77, 131, 15, 15, 24, 232, 28, 131, 113, 199, 241, 33, 3, 86, 146, 78, 124, 250, 52, 97, 64, 156, 228, 128, 195, 19, 62, 250, 62, 107, 132, 15, 227, 237, 220, 34, 133, 61, 202, 14, 241, 95, 106, 153, 44, 188, 125, 53, 61, 22, 201, 64, 202, 68, 0, 216, 71, 59, 228, 45, 26, 99, 251, 197, 34, 218, 40, 250, 70, 127, 56, 99, 234, 67, 98, 157, 101, 121, 231, 146, 117, 131, 247, 54, 196, 83, 21, 254, 106, 187, 83, 139, 89, 107, 41, 152, 184, 136, 52, 39, 66, 73, 72, 184, 153, 40, 65, 57, 248, 228, 152, 237, 101, 17, 226, 56, 160, 160, 196, 170, 49, 203, 231, 126, 60, 48, 244, 106, 245, 55, 152, 199, 212, 131, 115, 8, 237, 81, 13, 57, 28, 249, 96, 229, 56, 35, 204, 134, 59, 84, 104, 134, 128, 173, 69, 158, 0, 213, 239, 154, 37, 241, 71, 232, 40, 34, 162, 22, 191, 142, 80, 153, 153, 195, 99, 203, 111, 206, 30, 216, 116, 14, 203, 16, 143, 5, 135, 148, 54, 64, 146, 186, 98, 14, 46, 90, 204, 246, 22, 130, 232, 37, 148, 39, 250, 7, 116, 165, 93, 42, 99, 143, 213, 168, 18, 204, 19, 178, 242, 246, 159, 155, 229, 252, 86, 211, 152, 158, 155, 117, 58, 102, 244, 24, 75, 51, 16, 135, 140, 248, 250, 176, 83, 40, 141, 229, 133, 190, 105, 171, 184, 155, 236, 113, 31, 20, 231, 50, 106, 97, 241, 57, 46, 18, 244, 131, 28, 155, 250, 173, 10, 25, 141, 111, 129, 138, 122, 181, 162, 225, 237, 83, 22, 25, 252, 33, 209, 142, 101, 218, 218, 48, 163, 123, 228, 26, 33, 93, 246, 60, 251, 213, 172, 239, 40, 218, 27, 177, 30, 90, 250, 60, 7, 111, 76, 57, 227, 122, 173, 5, 255, 18, 175, 218, 249, 102, 29, 90, 171, 109};
		
		for(int i = 999; i >= 0 ; i--){
			reverse_integers_1000[i] = i;
		}
		
		//100 elements array of characters
		// generated with random.org and arraythis.com
		String[] random_strings_100 = {"hnot", "zltp", "posd", "izdm", "cbud", "vobq", "xqrl", "isdd", "yyuw", "pnvm", "eixi", "vaus", "curh", "ysrk", "vaxc", "ulmp", "rmeo", "amwp", "mrmb", "jqmf", "oulp", "tdrc", "xggh", "ctnu", "ruvr", "mgtr", "oxat", "rjsx", "moey", "znwn", "ouzk", "ufpx", "zexw", "hccy", "icid", "sisu", "tynx", "yoln", "vugc", "uwqm", "zgia", "toir", "mnax", "xgbn", "xbep", "rjbw", "byiu", "lwit", "gtcd", "omxz", "plkj", "muum", "ngaf", "effv", "zedp", "jkvn", "peqc", "qbmp", "vlpu", "ravh", "yyak", "hwpf", "bmqu", "dyhm", "wlae", "gjrm", "tsvz", "mrbn", "khne", "uarc", "aamy", "zmms", "cowv", "mlwd", "mmjx", "jbas", "mscp", "xqsv", "yicb", "poxd", "ktha", "yuuz", "xljz", "lyli", "hobe", "afcu", "cipy", "cmht", "jzix", "weav", "yinf", "lxmd", "ebrq", "amyn", "qmdh", "hpoy", "cykk", "xjho", "zofv", "cipv"};
		String[] ordered_strings_100 = random_strings_100;
		Arrays.sort(ordered_strings_100);
		String[] reverse_strings_100 = random_strings_100;
		Arrays.sort(reverse_strings_100, Collections.reverseOrder());
	
		//1000 elements array of characters
		// generated with random.org and arraythis.com
		String[] random_strings_1000 = {"znshv", "stiya", "sfjff", "mwrto", "nhgnq", "icaqq", "kvhlc", "kbiwi", "srmdg", "fekfc", "dfsac", "bwwnw", "looqf", "tbssp", "awgzc", "hzofb", "psqof", "urakd", "mpkgd", "cdgho", "qleet", "qvqdm", "zsxms", "gbxaw", "xcerx", "dztqj", "xaulc", "rmpnq", "bgadl", "sjctj", "ozkep", "blvcs", "ufwij", "mvpuf", "pucal", "twdrx", "intoc", "oglrw", "wuzrf", "lwjrp", "ugiah", "opewu", "mazlv", "soqsm", "vtqvc", "bsqka", "ikpkz", "fkdbn", "uahwo", "lflar", "bueqj", "luaea", "ivyyc", "fzlyc", "xoong", "sfytm", "chkwe", "tblek", "fidiw", "hftff", "nrmkd", "ruwnn", "luqsh", "znebh", "vbucc", "hghoo", "cqkmg", "xcxtt", "jeykj", "xkmqn", "qyddx", "wuqxw", "nsjey", "pumny", "uhqhp", "nwppq", "btrwq", "nlpeg", "ovxzz", "wzder", "bhlpw", "ebhst", "ljfeu", "hkxoh", "ycznu", "tsvnf", "uoslc", "cunxf", "omner", "vfnub", "rceuw", "qhjrl", "sgtvr", "isrzb", "nkdxo", "ukujx", "zceuh", "etcpj", "pwzpt", "exdoo", "bmxcj", "ltzhl", "iwcvi", "zqsit", "oujrv", "zkzku", "rjony", "leuvp", "bdlvu", "qurex", "avcce", "jnewu", "svggw", "srgon", "xgrjq", "spxik", "bferh", "apjov", "fisox", "dwylh", "nwxqr", "bfeuz", "ogmee", "eygdz", "wqaal", "dnhjg", "fyqts", "mabfw", "fvavy", "ggosf", "pcxbc", "tvtfq", "vokgz", "elzgq", "hinoe", "admlc", "amaie", "tmtbp", "yzilf", "dpxbn", "mgekj", "abdnc", "lisml", "gkkha", "uedtc", "kqglo", "jyade", "esgdb", "qmknb", "mnlwq", "tjexh", "slfvq", "tfwcy", "zbmbg", "qldmm", "okjjr", "zursv", "qztgg", "ujixk", "dyxxo", "wkpoo", "hskdr", "vhiul", "lozta", "kmdzv", "fbrdx", "rljye", "latzm", "arnwg", "ybivr", "ikpcw", "mmvkv", "dftcf", "asacp", "peclo", "nbpke", "rqxey", "vciyh", "tcbvb", "xvljs", "jzqvv", "akawv", "xuiso", "nlheu", "qpoea", "topid", "rhbzw", "acyaf", "nuiro", "cwaql", "szarz", "tzazy", "cmolj", "ssjph", "pdbrz", "nufkg", "azjeg", "syeai", "ughbw", "gwbhk", "uqgtq", "sxwxo", "oshpp", "aovso", "dzeit", "zkutx", "fwove", "nrrty", "fifre", "sxibx", "pjmbk", "dwsgf", "lvdmp", "bgsxj", "lunui", "nozuu", "ubkfu", "jpnqg", "kluul", "wqyyp", "ndseu", "fodjf", "knehb", "yvoma", "sinrf", "mfbim", "bbvwm", "xstji", "afztz", "lwzix", "avdvr", "kmqqm", "zokqx", "qnhiu", "wdyfy", "vpnah", "olkql", "kqbyy", "pcjfw", "zhopl", "vfslt", "aywcd", "kmwpm", "jzgfs", "mndxs", "nibdu", "qdzdc", "jmzaq", "vzrzb", "pzntq", "vabrs", "tsgms", "pruyz", "nlvkb", "ndmwr", "majip", "rgjei", "twgbz", "zwsbo", "cpftx", "xupll", "xqlln", "ovmil", "wfotu", "oztpn", "vmxop", "fzlpg", "ngqaz", "bpqix", "vumbj", "njfnb", "jlior", "vpfhb", "wfahf", "foaek", "wrpif", "vixlp", "jkhel", "oscgj", "okojf", "aggga", "zhsrq", "tlqer", "ngchf", "rsjqh", "fzpbm", "pyqsj", "kjary", "fxyjl", "xpmhm", "fbdhv", "cnbjb", "byqvh", "dbthi", "ffgtv", "gqnoq", "rbjja", "zinrb", "nkxyk", "zndvs", "wspfu", "twjlb", "qdctu", "eyjvv", "vtaqm", "bmoax", "hxndm", "tdcrp", "zmlii", "maknl", "mtdbx", "ovrix", "bnpxd", "pvizb", "oyzli", "forqq", "lmzlo", "mlhov", "sfede", "gqbap", "pyltd", "bkglx", "yufiv", "cdexv", "xnwgu", "zvovy", "ebkni", "toaxp", "ukgik", "iiohy", "wyevi", "lgjjp", "aqwbg", "mdgzg", "oasbs", "gdmnd", "xyfyk", "ljpwy", "gmdiz", "bjdvh", "jtmsm", "jvnae", "newok", "ceawc", "gehah", "ynbgj", "dkkio", "mjnyz", "tiguf", "kapwy", "dnwxl", "zturo", "grngw", "segoa", "kwqhy", "fxsov", "zauyo", "wamvj", "otlkq", "gcova", "yyrap", "lbfcf", "ownrw", "npsqb", "kvvzf", "zfknb", "vbvxs", "emvpi", "gwccf", "bhlod", "lhoij", "xhsbk", "cjwby", "yelgv", "eicdq", "pfsie", "rxrsc", "psiem", "bideg", "rtfxz", "lipww", "zjwoz", "xmykr", "wxzpq", "qyapn", "dyvsi", "tqfaz", "ywlck", "zvdlt", "tqjpg", "kcnmk", "lgndj", "scazg", "knojs", "lesfx", "igrvn", "ylffp", "bqnfj", "jknlo", "mrnrg", "zcelu", "vlvga", "qccle", "kiaao", "fixqx", "lqvuy", "ewfpj", "yqapl", "hurls", "ymvpm", "wbjos", "yalji", "fsycb", "jxhdf", "pfcfm", "ubntt", "hpaat", "ixjut", "ixdkl", "zcjdu", "ksvqc", "fcraq", "kdfcj", "qtjug", "lrlst", "tnwhd", "ipszw", "ftgbq", "bdkxq", "ibzlo", "dzbmz", "pprpk", "nybqy", "cfoew", "safve", "jrwyo", "drlrr", "zytpz", "khszy", "dxqoz", "nbpia", "jtzco", "cdoxh", "hmkdx", "totwj", "mgbem", "srggb", "whezt", "ygohc", "zkbcr", "fgewp", "haqah", "qdkrq", "nleqt", "qxwsr", "brubk", "csasz", "gikot", "gedcd", "ypyva", "dhwfu", "nvego", "mcfci", "zaeyx", "mvcxm", "redso", "iqzkr", "kahkv", "tadwm", "jmevl", "icnpw", "tzgxw", "rqgcf", "qrpzy", "akgyq", "sabgs", "kzdrv", "zwxxm", "jnemg", "swcho", "fapqj", "nlpeq", "bfnpi", "rqyxw", "anwwg", "xxpey", "yxomb", "ehwfu", "xlzxn", "qboxr", "fialk", "mvqbl", "dxayt", "mfnle", "uhrsp", "gvtwm", "blxbr", "yopsk", "eqxjo", "gizsn", "nfeer", "jkqfc", "epljg", "xpwgs", "oqbje", "vrnzs", "qsmkz", "acaxu", "gwvhq", "dzkcn", "xxjfy", "fmdna", "qcqgm", "pziab", "djtuf", "tdcgq", "rvzyi", "xmdft", "genei", "alhys", "fvyab", "ofqug", "ndmqe", "netga", "yffyw", "qopeg", "diawm", "itxpd", "wowdt", "wspgp", "qwwka", "sndis", "brhnb", "kwdhw", "xdsab", "rppss", "mrpkg", "ujxka", "pnrkj", "cncsu", "ehqml", "wsgwl", "wbwot", "zybyz", "slker", "wsmmy", "ibefp", "nxmmu", "wzpsw", "qbjsd", "pojec", "otyhs", "jfoad", "knrrp", "nrswh", "njlno", "uilfe", "kdhco", "rdrlq", "fjrcp", "xaujz", "knvdj", "txacs", "emyil", "bapzp", "fbvth", "cjwld", "qojoa", "gajaq", "zvjpb", "wrlcw", "pemsq", "kuftl", "rohtq", "wtewu", "ttjsu", "zkrqr", "jgpfi", "tkdkk", "clfeg", "isplp", "enanm", "xgdmf", "dzczq", "kckbk", "wsbmn", "lllmf", "vhlvd", "qtvbj", "aenjt", "wwbrz", "vcahi", "ywlgs", "irnpm", "plxor", "fxvjp", "jikhb", "kxmif", "fohqo", "exqdk", "oyxyv", "kgyhf", "upchp", "atdec", "luuoo", "ormsc", "aydoo", "cdnvw", "cuwfj", "mhuss", "cymdw", "uujji", "lihzr", "weefo", "rcgko", "vsxyf", "jkcvm", "xhnzs", "zqvdv", "habhx", "glbmp", "tugen", "invqx", "ltnuh", "juzcc", "uqdzc", "wgpbm", "ghfas", "ouubp", "nwuyf", "vrsoh", "evmge", "zdall", "unyvf", "ziwdi", "zbdgg", "amotz", "yvxbo", "goxdj", "ygkce", "mifvc", "yqpci", "kukrk", "wqmhy", "ucknp", "riash", "gblmk", "hkuaz", "ujfhx", "ssprl", "bdyfz", "iqbol", "mvxjm", "xtrbo", "fiwlr", "lbcfz", "dsnom", "gxpry", "nnosv", "powwm", "ggyqv", "kqyge", "tpeoj", "bdcmp", "jafpj", "wngux", "ixomb", "jtkur", "itovy", "ftspf", "lfzpi", "dpjfr", "ywlld", "dncqw", "pbxym", "pflrl", "qrxqo", "xqduq", "ygbvw", "gdgcp", "gimhj", "cdjwl", "fwtsc", "xkxst", "ynvun", "mcltf", "rrhjr", "hbuuu", "agmfn", "nmeac", "jssyd", "xoegy", "jbttl", "lnrko", "kdpce", "tmbwm", "oaxrj", "rdvfr", "pwbnw", "vmdda", "yxfdz", "efefh", "sftdz", "rlayu", "vujnx", "iuhjf", "gpsuq", "radxb", "zrsml", "mzzth", "jehmp", "oaago", "kxsjb", "enrcq", "saecn", "bzmlr", "glbxd", "yzoqa", "sjrqc", "azgjz", "mufnk", "rscfc", "pnlbo", "bueuq", "xmcne", "gkjnr", "jolpj", "zolfz", "dnsfv", "oobbj", "hpwpl", "uribt", "jcmgo", "evomx", "jlwoo", "xgqie", "vchxr", "bayra", "flsfr", "xhboj", "jybeo", "hcqiq", "khxol", "zbbmn", "schnq", "nyxhd", "kqsvk", "bgujn", "vztxl", "yepay", "kwren", "hecxp", "qjzqy", "cdwtt", "yvfpz", "tathd", "kgxop", "wcgfe", "hhzlz", "zpcnt", "jnabs", "ikcvl", "mpamu", "nzzdf", "jdzmq", "nywiz", "sgmqj", "wpaqr", "yyste", "csiij", "tcupo", "hbxxi", "kytdb", "sdvxl", "ugfpp", "rrwkj", "ziygc", "dhkte", "izatj", "yeywy", "lecai", "afctj", "kywez", "yuyky", "lufbt", "fcafk", "qdrkf", "asacx", "cfipr", "nobpr", "rtogo", "woctk", "rmwky", "xzgbd", "qqtkp", "ftozn", "xyemr", "oprrs", "rxqtr", "oudna", "gyuam", "gksqq", "njekx", "lzmtw", "xldra", "uexux", "zogcx", "zgrcb", "cgykp", "rrfms", "cnenb", "tcqxn", "hopii", "hsger", "mmxpo", "qzjkf", "qzscx", "meqwt", "ysnyg", "rfozy", "bxzdk", "uhutk", "oiokb", "uqvup", "srlye", "mbtcp", "dmbbl", "mzgpl", "vgpkl", "hclns", "zgctg", "xjdmq", "dqdyz", "zvbuk", "kyjju", "rqgdc", "mugar", "ivbxe", "klemv", "lbnqp", "qgjoe", "umvbf", "tybaz", "oznfi", "wtbci", "sxrxt", "crgws", "merty", "tdvsm", "tmmnf", "msyul", "himyv", "uqiau", "toido", "eqdbq", "hsjck", "ydypm", "lfkhh", "vgrty", "suewq", "xfclq", "nbtqb", "vldqc", "nhfiw", "ovvqp", "adjha", "msyrr", "ovqmw", "qvfkb", "raohy", "ecozc", "aeiuk", "cnumr", "lfqhr", "pmiyo", "dnghy", "euebg", "jgpvm", "ypdvm", "rircp", "jjqzl", "fztgi", "qcnhw", "pfirm", "iluzb", "zvwis", "fgrto", "tpuaf", "igukt", "bqkgh", "yvvkv", "nlxbg", "fstgk", "ecqqn", "zsmox", "xnmwf", "ksvse", "zcfck", "zlmey", "qhhtt", "hhqlp", "rlmeu", "grpky", "jfwad", "pktlz", "xpmlx", "nozml", "jtzlw", "mmeyt", "rvvko", "wdagy", "rrafs", "tmxvf", "hkprd", "ijghx", "zfwww", "rznxe", "iftrq", "pjjwd", "eznoj", "ehwju", "nvnch", "tpbdg", "zinpk", "djkdq", "nsihe", "cfeyb", "zoduk", "advpg", "uankd", "ecihc", "erlft", "ljsai", "qvhwy", "uetmf", "gvmmw", "xksva", "jsbqf", "lfjtp", "zazum", "rtoaq", "ahqqo", "sfwpz", "yjgal", "fhdfi", "batti", "vmcyf", "qkeaq", "kzwcb", "hlwke", "iwhjv", "lauui", "uzcdl", "lqqlu", "fuxtc", "eveaa", "joaxc", "qanbx", "nkcts", "huenk", "ukplu", "omplz", "mrgvn", "lltge", "nqnja", "lipqo", "qzoss", "wtsig", "optis", "wgcmn", "tfkiu", "bgrim", "fryni", "jzsno", "rejmz", "uigqw", "cmoox", "evuwy", "ypgpm", "zlwuy", "qppqp", "zywop", "rhgsb", "plzoy", "vmhnq", "rnylw", "crftl", "ydgrt", "mmnur", "uylpo", "kqqch", "wzhfg", "lrqij", "xjvuj", "rncqp", "hvfmb", "xjwjq", "xzvkd", "udenj", "wcbdr"};
		String[] ordered_strings_1000 = random_strings_1000;
		Arrays.sort(ordered_strings_1000);
		String[] reverse_strings_1000 = random_strings_1000;
		Arrays.sort(reverse_strings_1000, Collections.reverseOrder());

		//100 elements array of doubles
		// generated with meridianoutpost.com
		Double[] random_doubles_100 = {38.90,49.283,72.025,19.964,56.175,86.693,37.266,78.872,31.213,19.55,16.082,85.8,30.911,94.08,46.526,28.65,57.906,86.393,9.699,62.764,11.752,86.583,88.125,71.095,11.72,93.003,55.271,84.7,98.169,45.809,51.874,63.685,86.1,35.902,37.188,91.707,5.258,91.449,96.533,69.021,39.068,44.043,86.866,22.792,36.181,8.81,2.305,50.676,6.909,95.221,52.868,25.471,99.952,54.615,27.574,98.262,81.205,22.872,58.837,27.804,14.449,11.454,35.852,77.898,61.319,44.351,97.25,14.317,59.94,69.555,83.063,37.837,4.61,54.582,25.362,78.505,34.07,56.062,91.686,51.114,56.301,46.327,73.948,68.352,46.328,18.112,99.452,36.354,10.601,93.525,94.512,76.212,27.981,84.339,57.584,52.313,27.084,2.768,95.876,27.551};
		Double[] ordered_doubles_100 = random_doubles_100;
		Arrays.sort(ordered_doubles_100);
		Double[] reverse_doubles_100 = random_doubles_100;
		Arrays.sort(reverse_doubles_100, Collections.reverseOrder());
	
		//1000 elements array of doubles
		// generated with meridianoutpost.com
		Double[] random_doubles_1000 = {43.001,15.724,88.079,56.533,4.653,64.018,14.326,40.378,71.729,77.657,68.613,52.219,41.759,55.598,59.404,14.028,37.43,76.84,31.65,42.195,95.464,2.544,34.276,3.781,76.469,91.428,20.991,87.101,34.21,20.421,5.326,46.501,59.022,74.466,52.832,22.281,63.104,25.819,10.307,52.015,71.223,27.295,32.577,71.604,93.536,15.922,35.214,51.929,6.217,41.306,81.289,15.441,77.675,55.811,70.545,75.759,69.252,20.429,91.957,53.727,56.548,23.424,33.547,54.477,63.013,17.769,28.456,61.138,50.323,4.285,84.839,80.721,79.956,47.182,95.701,48.72,43.868,8.991,24.405,39.724,19.474,48.236,3.621,70.836,21.926,76.246,75.041,72.098,21.36,40.355,97.284,1.786,17.624,58.7,42.299,44.945,49.389,57.084,38.717,24.963,91.89,55.36,55.768,78.782,93.542,29.167,71.253,51.43,60.45,78.078,70.062,36.085,30.162,10.406,97.582,95.005,80.537,55.551,40.471,22.536,68.695,13.6,27.952,24.838,14.139,51.377,48.102,2.513,55.964,40.133,48.061,37.789,80.072,81.403,61.587,76.061,36.648,34.378,24.182,53.202,93.364,10.806,22.615,37.125,26.563,38.59,17.815,68.425,65.292,17.077,34.752,70.901,37.145,88.926,33.242,48.814,92.793,15.468,72.634,92.886,58.431,34.788,97.186,36.015,68.159,99.775,58.414,50.453,45.741,46.018,36.799,49.667,50.904,97.542,59.927,35.755,93.928,76.696,18.029,25.776,15.484,21.903,99.032,79.336,7.412,3.743,51.343,65.286,47.036,2.254,68.285,95.281,94.042,24.511,77.241,49.342,49.21,31.398,20.191,44.45,79.659,89.114,95.749,4.057,10.006,60.821,14.166,56.447,12.511,7.684,43.33,9.844,12.717,92.397,32.544,38.858,41.558,59.035,77.332,93.819,84.199,49.575,11.385,21.958,11.111,30.667,68.507,81.656,58.224,12.718,70.66,22.911,69.55,4.736,89.522,91.516,36.689,55.491,59.968,64.823,98.533,50.916,28.793,4.583,63.796,17.69,13.36,95.47,50.512,28.279,85.215,54.119,83.36,75.714,13.355,17.474,24.383,62.679,46.575,82.9,60.428,80.224,8.419,29.337,37.709,71.877,46.026,17.673,36.241,11.303,84.008,26.39,65.122,16.704,24.957,12.226,5.185,56.894,79.637,3.11,24.462,80.627,60.57,1.462,26.174,47.702,56.221,49.677,28.563,50.839,14.224,87.452,70.297,14.492,6.34,4.339,78.378,7.192,55.928,17.01,77.455,41.954,30.746,24.493,77.092,43.69,77.11,8.195,1.78,47.132,8.947,48.648,48.052,24.14,39.026,60.646,88.11,68.122,43.093,15.161,22.697,9.197,57.018,93.048,18.33,52.016,44.186,69.07,40.579,44.767,76.786,43.714,71.076,26.757,81.415,93.363,38.315,77.9,65.352,6.895,55.097,42.084,44.341,43.081,30.707,25.738,46.257,47.839,62.389,52.52,89.305,58.886,90.866,5.116,88.955,61.28,11.152,15.279,98.873,19.973,15.076,41.829,94.248,98.833,35.291,5.961,1.508,41.576,52.251,68.965,87.947,41.356,26.572,20.443,78.156,98.621,54.012,44.705,2.112,91.446,53.23,81.085,83.028,45.843,83.377,22.724,50.726,54.113,40.357,76.893,31.952,55.544,54.17,33.015,12.688,72.464,21.353,60.754,88.556,6.023,51.372,61.22,21.982,4.736,47.313,76.827,3.207,8.871,79.992,97.429,51.295,3.55,2.963,55.984,73.338,43.059,85.979,15.105,61.773,94.965,68.577,34.213,90.672,45.68,50.431,92.348,70.096,24.611,65.659,6.011,8.858,43.204,2.262,7.285,41.685,40.167,29.264,27.983,76.562,64.015,99.219,63.45,88.133,58.538,56.167,23.97,56.276,15.316,53.421,75.415,78.874,12.178,25.102,96.91,8.369,30.729,82.144,19.936,76.803,70.61,40.998,57.952,99.543,19.02,73.191,17.165,15.628,77.013,93.283,59.435,85.387,98.013,22.617,44.691,28.209,60.015,96.918,58.384,59.047,99.455,50.445,74.189,88.921,46.924,62.081,47.35,67.538,79.332,53.676,31.06,90.89,42.005,90.19,30.085,58.014,18.856,57.125,35.328,53.983,67.866,63.361,61.896,18.148,89.381,9.027,8.094,75.403,49.639,5.491,9.965,98.075,94.648,40.738,71.718,90.516,45.741,24.366,27.152,35.35,19.965,73.636,63.828,74.856,18.455,74.418,68.236,45.067,70.317,3.203,8.05,50.035,87.653,45.455,10.671,42.264,43.945,89.103,60.114,62.839,27.099,84.577,24.179,29.333,6.933,48.073,56.058,29.871,41.855,84.806,87.344,61.165,2.388,67.65,4.549,72.794,27.773,62.56,4.783,49.812,48.027,40.1,51.716,33.933,19.213,97.439,49.656,2.541,66.601,14.857,79.559,65.013,95.851,1.145,36.866,50.952,60.265,57.813,54.025,13.566,50.704,93.479,41.23,27.681,95.883,37.848,7.176,73.173,84.116,97.801,76.902,43.276,94.989,19.671,54.286,45.14,51.585,69.07,35.248,66.692,44.904,47.253,94.109,60.298,19.907,76.652,46.79,15.773,99.566,32.935,2.384,41.531,86.649,60.568,40.16,59.43,30.944,31.758,47.215,4.386,99.121,51.675,23.025,67.065,24.729,32.973,78.466,23.034,41.617,60.037,41.496,15.61,53.276,13.215,50.794,84.025,24.831,19.205,87.505,75.357,1.853,58.663,14.8,94.827,53.98,68.245,87.955,50.003,68.782,57.38,22.293,63.859,80.465,87.682,99.391,99.411,82.537,81.332,64.892,81.137,95.811,90.841,30.908,26.651,49.348,18.875,47.985,67.561,81.206,21.174,95.755,21.54,54.026,46.759,59.041,22.859,8.367,70.724,34.213,78.352,49.115,96.35,1.004,31.162,54.009,73.846,12.144,48.548,80.02,69.141,47.636,65.544,71.763,77.231,26.882,41.914,78.139,89.755,54.121,49.047,43.544,46.946,30.709,20.798,57.071,13.759,95.021,50.344,74.437,41.168,34.316,20.898,66.99,55.326,63.761,17.963,69.555,82.296,65.916,55.704,30.18,3.99,95.958,97.807,25.875,67.126,74.689,34.69,74.091,12.154,11.666,34.073,25.97,36.916,76.492,27.341,8.074,23.921,64.93,51.473,87.817,28.299,2.677,74.531,75.319,97.055,43.246,37.539,84.982,11.609,71.692,67.627,19.069,5.365,35.748,1.884,47.246,14.274,58.829,27.717,50.135,57.479,81.164,55.419,64.682,64.101,41.052,65.994,20,16.52,26.74,15.487,26.495,95.783,21.434,11.878,39.361,45.55,86.366,40.806,42.981,87.601,35.673,97.209,88.06,54.358,35.524,24.077,8.853,47.316,58.653,65.299,41.073,18.518,30.472,29.505,46.614,27.224,77.189,60.687,99.57,17.315,4.453,65.938,56.046,74.832,85.616,38.039,69.847,49.58,72.04,91.002,62.167,22.847,77.372,80.247,96.219,13.082,13.379,35.999,94.631,60.575,88.082,29.589,57.123,82.131,8.293,28.146,37.704,34.994,77.88,23.895,88.852,48.595,88.531,4.581,52.028,55.435,38.673,59.005,15.408,62.395,3.964,17.669,52.448,65.127,78.718,80.033,32.898,48.896,22.138,29.918,32.461,45.626,93.08,66.305,6.375,61.203,3.538,76.937,43.959,68.915,77.147,73.869,71.518,7.823,71.009,54.457,2.867,10.704,77.723,45.215,16.248,53.344,48.61,95.532,8.141,50.308,25.037,25.869,59.701,76.279,71.494,74.989,33.758,37.817,96.226,96.142,64.053,56.26,6.66,80.95,98.339,22.258,17.934,70.045,12.773,27.278,17.13,13.153,59.411,88.826,16.543,60.072,5.739,42.841,94.776,79.734,27.745,88.116,1.732,98.304,2.462,66.754,87.37,30.73,35.014,86.962,67.609,20.334,13.476,52.203,94.781,79.124,94.532,93.315,94.262,97.444,99.482,58.872,26.417,43.147,50.905,19.222,70.724,3.948,17.62,35.337,55.848,96.755,50.761,52.83,82.22,88.298,30.88,91.951,62.838,8.199,2.979,11.424,38.883,55.964,82.123,78.03,55.168,15.613,28.779,20.851,67.807,16.685,50.829,33.182,73.505,21.125,13.363,50.108,28.638,60.61,50.299,86.519,64.919,46.012,24.715,30.838,26.772,72.61,42.446,45.948,30.505,25.114,17.429,4.37,8.932,87.676,23.905,23.391,95.225,13.672,29.285,71.874,40.567,73.89,21.197,27.773,77.119,58.931,26.398,27.732,23.525,10.891,60.695};
		Double[] ordered_doubles_1000 = random_doubles_1000;
		Arrays.sort(ordered_doubles_1000);
		Double[] reverse_doubles_1000 = random_doubles_1000;
		Arrays.sort(reverse_doubles_1000, Collections.reverseOrder());
		

		Integer[][] allInteger = {ordered_integers_100, reverse_integers_100, random_integers_100, ordered_integers_1000, reverse_integers_1000, random_integers_1000};
		String[][] allString = {random_strings_100, ordered_strings_100, reverse_strings_100, random_strings_1000, ordered_strings_1000, reverse_strings_1000};
		Double[][] allDouble = {ordered_doubles_100, reverse_doubles_100, random_doubles_100, ordered_doubles_1000, reverse_doubles_1000, random_doubles_1000};

		float[] timeA1 = new float[12];
		float[] timeA2 = new float[12];
		float[] timeA3 = new float[12];

		testWhileNeeded(allInteger, allString, allDouble, timeA1);
		testUntilNoChange(allInteger, allString, allDouble, timeA2);
		testPassPerItem(allInteger, allString, allDouble, timeA3);

		System.out.println("A1--------");
		for (float m : timeA1) {
			System.out.println(m);
		}
		System.out.println("A2--------");
		for (float m : timeA2) {
			System.out.println(m);
		}
		System.out.println("A3--------");
		for (float m : timeA3) {
			System.out.println(m);
		}

		// 500 iterations
		// Warm up 50 cycles

	}

	public static void testWhileNeeded(Integer[][] allInteger, String[][] allString, Double[][] allDouble, float[] timeA1) {
		int j = 0;
		// Warm up cycles
		for(int i = 0; i < 50; i++) {
			whileNeeded.sort(allInteger[0]);
		}

		for (Integer[] o : allInteger) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				whileNeeded.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA1[j] = avg;
			j += 1;
		}
		for (String[] o : allString) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				whileNeeded.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA1[j] = avg;
			j += 1;
		}
		for (Double[] o : allDouble) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				untilNoChange.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA1[j] = avg;
			j += 1;
		}

		return;
	}

	public static void testUntilNoChange(Integer[][] allInteger, String[][] allString, Double[][] allDouble, float[] timeA2) {
		int j = 0;
		// Warm up cyles
		for(int i = 0; i < 50; i++) {
			untilNoChange.sort(allInteger[0]);
		}
		
		for (Integer[] o : allInteger) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				untilNoChange.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA2[j] = avg;
			j += 1;
		}
		for (String[] o : allString) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				untilNoChange.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA2[j] = avg;
			j += 1;
		}
		for (Double[] o : allDouble) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				untilNoChange.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA2[j] = avg;
			j += 1;
		}
		return;
	}

	public static void testPassPerItem(Integer[][] allInteger, String[][] allString, Double[][] allDouble, float[] timeA3) {
		int j = 0;
		// Warm up cycles
		for(int i = 0; i < 50; i++) {
			passPerItem.sort(allInteger[0]);
		}
		
		for (Integer[] o : allInteger) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				passPerItem.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA3[j] = avg;
			j += 1;
		}
		for (String[] o : allString) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				passPerItem.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA3[j] = avg;
			j += 1;
		}
		for (Double[] o : allDouble) {
			float sum  = 0;
			for (int i = 0; i < iterations; i++) {
				long start = System.nanoTime();
				untilNoChange.sort(o);
				long end = System.nanoTime();
				long result = end - start;
				sum += result;
			}
			float avg = sum / iterations;
			timeA3[j] = avg;
			j += 1;
		}
		return;
	}

}