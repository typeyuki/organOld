<style>
    @media only screen and (min-width: 6000px){
        #label .title{
            text-align: center;
            font-size: 35px;
            font-weight: bold;
        }
        #label .ta{
            margin-top: 55%;
            font-size: 50px;
            position: relative;
            left: 20%;
        }
        #label .secTitle{
            text-align: center;
            font-size: 15px;
            font-weight: bold;
            margin-top: 8px;
        }
        #label .qk_1{
            font-size: 30px;
            padding:10px 30px;
            color: white;
            border: none;
            border-radius: 10px;
            margin: 10px;
            width: 80%;
        }
        #label .label{
            font-size: 30px;
            padding:5px!important;
            margin: 5px!important;
            line-height: 2!important;
        }
    }
        .label_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
        h2,p,td,h3,h1,span{
            color: white!important;
        }
        .select{
            opacity: 0.5;
        }
        .qk{
             font-size: 24px;
             background-color:#6cbdfc ;
             padding:10px 30px;
             color: white;
             border: none;
             border-radius: 10px;
             margin-bottom: 10px;
            /*position: fixed;*/
            /*bottom: 5%;*/
            /*left:3%*/
         }

        .bl{
            display: inline-block;
            line-height: 1!important;
        }
        .color_1{
            background-color:#6cbdfc!important;;
        }
        .color_2{
            background-color:#dc88a9!important;;
        }
        .color_4{
            background-color:#48e8dc!important;;
        }
        .color_5{
            background-color:yellowgreen!important;;
        }
        .color_6{
            background-color:orange!important;;
        }
        .color_7{
            background-color:rgb(139, 182, 93)!important;;
        }
        #label3{
            display: none;
            margin-top: 20%;
            padding: 50px;
        }
    .daohang{
        font-size: 40px;
        color: white;
        background-color: transparent;
        border: 15px solid #47e3d8;
        padding: 20px 40px;
        border-radius: 100%;
        font-weight: bold;
    }
    </style>
<div class="row">
    <div class="col-lg-1" style="width: 5%"></div>
    <div class="col-lg-5">
        <div class="row">
            <div class="col-lg-12 box">
                <div class="zz"></div>
                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6" align="center">
                        <button class="daohang">老有<br>所养</button>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
                <div class="row">
                    <div class="col-lg-6" align="left">
                        <button class="daohang">老有<br>所医</button>
                    </div>
                    <div class="col-lg-6" align="right">
                        <button class="daohang">老有<br>所为</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-5" align="center">
                        <button class="daohang">老有<br>所学</button>
                    </div>
                    <div class="col-lg-5" align="center">
                        <button class="daohang">老有<br>所乐</button>
                    </div>
                    <div class="col-lg-1"></div>
                </div>
            </div>
        </div>

        <div class="row box" style="margin-top: 20px" id="label1">
            <div class="zz"></div>
            <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                <div class="col-lg-5" >
                    <p class="title ta"  onclick="picChange(1)">身份标签</p>
                </div>
                <div class="col-lg-7">
                    <div class="row">
                        <div class="col-lg-12" align="right">
                             <button class="qk_1 color_2" onclick="label3Show(31)">基 本 信 息</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12" align="right">
                            <button class="qk_1 color_2" onclick="label3Show(32)">健 康 档 案</button>
                        </div>
                     </div>
                    <div class="row">
                        <div class="col-lg-12" align="right">
                            <button class="qk_1 color_2" onclick="label3Show(33)">经 济 条 件</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12" align="right">
                            <button class="qk_1 color_2" onclick="label3Show(34)">家 庭 结 构</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12" align="right">
                            <button class="qk_1 color_2" onclick="label3Show(35)">养 老 状 态</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div id="label31" class="row box label3" style="display: none;margin-top: 20px">
                <div class="zz"></div>
                <div class="col-lg-12">
                    <span class="label color_1">男</span>
                    <span class="label color_1">女</span>
                    <span class="label color_1">60-70岁</span>
                    <span class="label color_1">70-80岁</span>
                    <span class="label color_1">90岁以上</span>
                    <span class="label color_1">东兰</span>
                    <span class="label color_1">平阳</span>
                    <span class="label color_1">古美</span>
                    <span class="label color_1">平吉</span>
                    <span class="label color_1">平南</span>
                    <span class="label color_1">古龙</span>
                    <span class="label color_1">户籍</span>
                    <span class="label color_1">非户籍</span>
                    <span class="label color_1">人户分离</span>
                    <span class="label color_1">群众</span>
                    <span class="label color_1">党员</span>
                </div>
            </div>
        <div id="label32" class="row box label3" style="display: none;margin-top: 20px">
            <div class="zz"></div>
            <div class="col-lg-12">
                <span class="label color_2">智力正常</span>
                <span class="label color_2">痴呆</span>
                <span class="label color_2">智障</span>
                <span class="label color_2">视力正常</span>
                <span class="label color_2">失明</span>
                <span class="label color_2">有光感</span>
                <span class="label color_2">严重障碍</span>
                <span class="label color_2">一般障碍</span>
                <span class="label color_2">有慢病</span>
                <span class="label color_2">有失能情况</span>
                <span class="label color_2">有药物反应</span>
                <span class="label color_2">有恶性肿瘤史</span>
                <span class="label color_2">有骨折史</span>
                <span class="label color_2">有残疾史</span>
            </div>
        </div>
        <div id="label33" class="row box label3" style="display: none;margin-top: 20px">
            <div class="zz"></div>
            <div class="col-lg-12">
                <span class="label color_3">帮困人员</span>
                <span class="label color_3">低保</span>
                <span class="label color_3">城乡居民养老保险</span>
                <span class="label color_3">医疗救助金</span>
                <span class="label color_3">城镇居民基本医疗保险</span>
                <span class="label color_3">其他</span>
            </div>
        </div>
        <div id="label34" class="row box label3" style="display: none;margin-top: 20px">
            <div class="zz"></div>
            <div class="col-lg-12">
            <span class="label color_4">纯老</span>
            <span class="label color_4">独居</span>
            <span class="label color_4">孤老</span>
            <span class="label color_4">一老养一老</span>
            <span class="label color_4">失独家庭</span>
            <span class="label color_4">三支人员</span>
                <span class="label color_4">独生子女家庭</span>
                <span class="label color_4">军属</span>
                <span class="label color_4">烈士家庭</span>
                <span class="label color_4">离休干部</span>
                <span class="label color_4">侨属</span>
            </div>
        </div>
        <div id="label35" class="row box label3" style="display: none;margin-top: 20px">
            <div class="zz"></div>
            <div class="col-lg-12">
                <span class="label color_5">东兰养老院</span>
                <span class="label color_5">古美养老院</span>
                <span class="label color_5">平阳养老院</span>
                <span class="label color_5">东兰长者照护之家</span>
                <span class="label color_5">古美长者照护之家</span>
                <span class="label color_5">平阳长者照护之家</span>
                <span class="label color_5">东兰日照中心</span>
                <span class="label color_5">古美日照中心</span>
                <span class="label color_5">平阳日照中心</span>
                <span class="label color_5">东兰助餐点</span>
                <span class="label color_5">古美助餐点</span>
                <span class="label color_5">平阳助餐点</span>
                <span class="label color_5">2-3级</span>
                <span class="label color_5">4级</span>
                <span class="label color_5">5级</span>
                <span class="label color_5">6级</span>
                <span class="label color_5">7级</span>
                <span class="label color_5">2-3级</span>
                <span class="label color_5">4级</span>
                <span class="label color_5">5级</span>
                <span class="label color_5">6级</span>
                <span class="label color_5">7级</span>
                <span class="label color_5">助餐</span>
                <span class="label color_5">助洁</span>
                <span class="label color_5">助急</span>
                <span class="label color_5">助浴</span>
                <span class="label color_5">助行</span>
                <span class="label color_5">康复辅助</span>
                <span class="label color_5">助医</span>
                <span class="label color_5">相谈</span>
                <span class="label color_5">洗涤</span>
                <span class="label color_5">生活护理</span>
            </div>
        </div>
        <div class="row box selectLabel" style="margin-top: 5px;">
            <div class="zz"></div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-12">
                        <p class="title">所选标签</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div id="selectLabel"></div>
                    </div>
                </div>
                <div class="row" align="center">
                    <div class="col-lg-12">
                        <button class="qk" style="background-color: #47e6da" onclick="butt()">确认</button>
                        <button class="qk" onclick="butt()">清空</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#--<div class="col-lg-5" id="label1" >-->
        <#--<div class="row box">-->
            <#--<div class="zz"></div>-->
            <#--<div class="row" style="border-bottom: 1px solid white;margin: 0!important;">-->
                <#--<div class="col-lg-5">-->
                    <#--<p class="title" style="margin-top: 20%;" onclick="picChange(1)">老 有 所 养</p>-->
                <#--</div>-->
                <#--<div class="col-lg-7">-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_2" onclick="label3Show(3)">机 构 养 老</button>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_2" onclick="label3Show(4)">社  区 养 老</button>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_2" onclick="label3Show(5)">经 济 条 件</button>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="row" style="border-bottom: 1px solid white;margin: 0!important;">-->
                <#--<div class="col-lg-5">-->
                    <#--<p class="title" style="margin-top: 50%;" onclick="picChange(2)">老 有 所 医</p>-->
                <#--</div>-->
                <#--<div class="col-lg-7">-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_4" onclick="label3Show(6)">慢 病</button>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_4" onclick="label3Show(7)">长 护 险</button>-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_4" onclick="label3Show(8)">失 能 情 况</button>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_4" onclick="label3Show(9)">智 力</button>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_4" onclick="label3Show(10)">视 力</button>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="row" style="border-bottom: 1px solid white;margin: 0!important;">-->
                <#--<div class="col-lg-5">-->
                    <#--<p class="title" style="margin-top: 5%;" onclick="picChange(3)">老 有 所 为</p>-->
                <#--</div>-->
                <#--<div class="col-lg-7">-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_5" onclick="label3Show(11)">志 愿 者</button>-->
                        <#--</div>-->
                    <#--</div>-->

                <#--</div>-->
            <#--</div>-->
            <#--<div class="row" style="border-bottom: 1px solid white;margin: 0!important;">-->
                <#--<div class="col-lg-5">-->
                    <#--<p class="title" style="margin-top: 5%;" onclick="picChange(4)">老 有 所 学</p>-->
                <#--</div>-->
                <#--<div class="col-lg-7">-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_6" onclick="label3Show(12)">学 校</button>-->
                        <#--</div>-->
                    <#--</div>-->

                <#--</div>-->
            <#--</div>-->
            <#--<div class="row" style="margin: 0!important;border-bottom: 1px solid white;">-->
                <#--<div class="col-lg-5">-->
                    <#--<p class="title" style="margin-top: 5%;" onclick="picChange(5)">老 有 所 乐</p>-->
                <#--</div>-->
                <#--<div class="col-lg-7">-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_7" onclick="label3Show(13)">俱 乐 部</button>-->
                        <#--</div>-->
                    <#--</div>-->

                <#--</div>-->
            <#--</div>-->
            <#--<div class="row" style="border-bottom: 1px solid white;margin: 0!important;">-->
                <#--<div class="col-lg-5">-->
                    <#--<p class="title" style="margin-top: 15%;" onclick="showHeatMap()">老 人 身 份</p>-->
                <#--</div>-->
                <#--<div class="col-lg-7" >-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_1" onclick="label3Show(1)">基  本  情  况</button>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="row">-->
                        <#--<div class="col-lg-12">-->
                            <#--<button class="qk_1 color_1" onclick="label3Show(2)">家  庭  结  构</button>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
        <#--<div class="row box" style="margin-top: 5px">-->
            <#--<div class="zz"></div>-->
            <#--<div class="col-lg-12">-->
                <#--<div class="row">-->
                    <#--<div class="col-lg-12">-->
                        <#--<p class="title">所选标签</p>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="row">-->
                    <#--<div class="col-lg-12">-->
                        <#--<div id="selectLabel"></div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="row" align="center">-->
                    <#--<div class="col-lg-12">-->
                        <#--<button class="qk" onclick="butt()">清空</button>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
    <#--<div class="col-lg-5 box" id="label3" >-->
        <#--<div class="zz"></div>-->
        <#--<div id="label31" class="aa" style="display: none">-->
            <#--<span class="label color_1">男</span>-->
            <#--<span class="label color_1">女</span>-->
            <#--<span class="label color_1">60-70岁</span>-->
            <#--<span class="label color_1">70-80岁</span>-->
            <#--<span class="label color_1">90岁以上</span>-->
            <#--<span class="label color_1">东兰</span>-->
            <#--<span class="label color_1">平阳</span>-->
            <#--<span class="label color_1">古美</span>-->
            <#--<span class="label color_1">平吉</span>-->
            <#--<span class="label color_1">平南</span>-->
            <#--<span class="label color_1">古龙</span>-->
        <#--</div>-->
        <#--<div id="label32" class="aa" style="display: none">-->
            <#--<span class="label color_1">户籍</span>-->
            <#--<span class="label color_1">非户籍</span>-->
            <#--<span class="label color_1">纯老</span>-->
            <#--<span class="label color_1">独居</span>-->
            <#--<span class="label color_1">孤老</span>-->
            <#--<span class="label color_1">一老养一老</span>-->
            <#--<span class="label color_1">失独家庭</span>-->
            <#--<span class="label color_1">三支人员</span>-->
            <#--<span class="label color_1">离休干部</span>-->
        <#--</div>-->
        <#--<div id="label33" class="aa" style="display: none">-->
            <#--<span class="label color_2">东兰养老院</span>-->
            <#--<span class="label color_2">古美养老院</span>-->
            <#--<span class="label color_2">平阳养老院</span>-->
        <#--</div>-->
        <#--<div id="label34" class="aa" style="display: none">-->
            <#--<span class="label color_2">东兰长者照护之家</span>-->
            <#--<span class="label color_2">古美长者照护之家</span>-->
            <#--<span class="label color_2">平阳长者照护之家</span>-->
            <#--<span class="label color_2">东兰日照中心</span>-->
            <#--<span class="label color_2">古美日照中心</span>-->
            <#--<span class="label color_2">平阳日照中心</span>-->
            <#--<span class="label color_2">东兰助餐点</span>-->
            <#--<span class="label color_2">古美助餐点</span>-->
            <#--<span class="label color_2">平阳助餐点</span>-->
        <#--</div>-->
        <#--<div id="label35" class="aa" style="display: none">-->
            <#--<span class="label color_2">帮困人员</span>-->
            <#--<span class="label color_2">低保</span>-->
            <#--<span class="label color_2">城乡居民养老保险</span>-->
            <#--<span class="label color_2">医疗救助金</span>-->
            <#--<span class="label color_2">城镇居民基本医疗保险</span>-->
        <#--</div>-->
        <#--<div id="label36" class="aa" style="display: none">-->
            <#--<span class="label color_4">高血压</span>-->
            <#--<span class="label color_4">糖尿病</span>-->
            <#--<span class="label color_4">脑卒中</span>-->
            <#--<span class="label color_4">帕金森</span>-->
            <#--<span class="label color_4">癫痫</span>-->
            <#--<span class="label color_4">肺炎</span>-->
            <#--<span class="label color_4">慢阻肺</span>-->
            <#--<span class="label color_4">冠心病</span>-->
            <#--<span class="label color_4">慢性肾功能障碍</span>-->
            <#--<span class="label color_4">甲亢/甲减</span>-->
            <#--<span class="label color_4">肝炎/肝硬化</span>-->
            <#--<span class="label color_4">恶性肿瘤</span>-->
            <#--<span class="label color_4">骨折</span>-->
            <#--<span class="label color_4">其他消化道疾病</span>-->
            <#--<span class="label color_4">类风关</span>-->
        <#--</div>-->
        <#--<div id="label37" class="aa" style="display: none">-->
            <#--<span class="label color_4">2-3级</span>-->
            <#--<span class="label color_4">4级</span>-->
            <#--<span class="label color_4">5级</span>-->
            <#--<span class="label color_4">6级</span>-->
            <#--<span class="label color_4">7级</span>-->
        <#--</div>-->
        <#--<div id="label38" class="aa" style="display: none">-->
            <#--<span class="label color_4">上厕所</span>-->
            <#--<span class="label color_4">洗澡</span>-->
            <#--<span class="label color_4">穿衣</span>-->
            <#--<span class="label color_4">上下床</span>-->
            <#--<span class="label color_4">室内行走</span>-->
            <#--<span class="label color_4">吃饭</span>-->
        <#--</div>-->
        <#--<div id="label39" class="aa" style="display: none">-->
            <#--<span class="label color_4">痴呆</span>-->
            <#--<span class="label color_4">智障</span>-->
            <#--<span class="label color_4">正常</span>-->
        <#--</div>-->
        <#--<div id="label310" class="aa" style="display: none">-->
            <#--<span class="label color_4">失明</span>-->
            <#--<span class="label color_4">有光感</span>-->
            <#--<span class="label color_4">有障碍</span>-->
            <#--<span class="label color_4">正常</span>-->
        <#--</div>-->
        <#--<div id="label311" class="aa" style="display: none">-->
            <#--<span class="label color_5">志愿者</span>-->
        <#--</div>-->
        <#--<div id="label312" class="aa" style="display: none">-->
            <#--<span class="label color_6">老年大学</span>-->
            <#--<span class="label color_6">老年培训中心</span>-->
        <#--</div>-->
        <#--<div id="label313" class="aa" style="display: none">-->
            <#--<span class="label color_7">老年俱乐部</span>-->
            <#--<span class="label color_7">老年艺术中心</span>-->
        <#--</div>-->
    <#--</div>-->
    <div class="col-lg-1" style="width: 3%"></div>
    <div class="col-lg-5" style="width: 46%;position: relative;left: -1.5%">
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_ageBar" class="label_tu"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_sexPie" class="label_tu"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_hjPie" class="label_tu"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_pqBar" class="label_tu"></div>
            </div>
        </div>
        <script type="text/javascript">
            var label_tu_w,label_tu_h;
            var label_width=$("#label").width();
            if(winWidth>=1900){
                label_tu_w=label_width/2.5;
                label_tu_h=winHeight/6.5;
            }else if(winWidth<=1400 && winWidth>=1300){
                label_tu_w=winWidth/3;
                label_tu_h=winHeight/5.5;
            }
            $(".label_tu").css('width',label_tu_w);
            $(".label_tu").css( 'height', label_tu_h);
            var label_ageBar = echarts.init(document.getElementById('label_ageBar'));
            var label_sexPie= echarts.init(document.getElementById('label_sexPie'));
            var label_pqBar= echarts.init(document.getElementById('label_pqBar'));
            var label_hjPie= echarts.init(document.getElementById('label_hjPie'));
        </script>
    </div>
</div>

<script>
    //    年龄分布柱状图
    title_text='年龄分布柱状';
    legend_data=[
        {
            name:'男',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'女',
            textStyle:{
                color:'#fff'
            }}
    ];
    yAxis_data=['90-','80-90','70-80','60-70'];
    series=[
        {
            name: '男',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideLeft'
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [67,134,234,534]
        },
        {
            name: '女',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [7,34,134,234]
        }
    ];
    var label_option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //性别饼图
    title_text="性别分布饼图";
    legend_data=[{name:'男',textStyle:{color:legend_color}},{name:'女',textStyle:{color:legend_color}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 20
                }
            }
        },
        data:[
            {value:476, name:'男'},
            {value:376, name:'女'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var label_option_sex_pie = chartPie(title_text,legend_data,series);
    //片区人数分布
    // legend_data="";
    // title_text='片区人口分布柱状';
    // yAxis_data=['东兰','古龙','平南','平阳','平吉','古美'];
    // series=[
    //     {
    //         name: '',
    //         type: 'bar',
    //         stack: '总量',
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'right',
    //                 textStyle:{
    //                     fontSize:20
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1
    //             }
    //         },
    //         data: [67,134,234,534,263,231]
    //     }
    // ];
    // var label_option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //aa
    var posList = [
        'left', 'right', 'top', 'bottom',
        'inside',
        'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
        'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
    ];

    label_pqBar.configParameters = {
        rotate: {
            min: -90,
            max: 90
        },
        align: {
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: echarts.util.reduce(posList, function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };

    label_pqBar.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
            var labelOption = {
                normal: {
                    rotate: label_pqBar.config.rotate,
                    align: label_pqBar.config.align,
                    verticalAlign: label_pqBar.config.verticalAlign,
                    position: label_pqBar.config.position,
                    distance: label_pqBar.config.distance
                }
            };
            label_pqBar.setOption({
                series: [{
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }]
            });
        }
    };


    var labelOption = {
        normal: {
            show: true,
            position: label_pqBar.config.position,
            distance: label_pqBar.config.distance,
            align: label_pqBar.config.align,
            verticalAlign: label_pqBar.config.verticalAlign,
            rotate: label_pqBar.config.rotate,
            formatter: '{c}',
            fontSize: 16,
            rich: {
                name: {
                    textBorderColor: '#fff'
                }
            }
        }
    };

    option = {
        //color: ['#003366', '#006699', '#4cabce', '#e5323e'],
        title: {
            text:'片区人口分布柱状',
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%',
        },
        color: ['#ffd289'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: ['东兰','古龙','平南','平阳','平吉','古美'],
                axisLine:{
                    lineStyle:{
                        color:'white',
                        fontSize: 20
                    }
                },
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color:'white',
                        fontSize: 20
                    }
                },
            }
        ],
        series: [
            {
                type: 'bar',
                barGap: 0,
                label: labelOption,
                data: [320, 332, 301, 334, 390,440],
                barWidth: 20,//柱图宽度
                itemStyle: {
                    normal: {
                        barBorderRadius: 20,
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#99d9ea'
                        }, {
                            offset: 1,
                            color: 'rgba(0,188,226, 0.5)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.4)',
                        shadowBlur: 20,
                    }
                }

            },

        ]
    };
    //pqBar.setOption(option);
    label_pqBar.setOption(option);


    title_text="户籍分布饼图";
    legend_data=[{name:'户籍',textStyle:{color:legend_color}},{name:'非户籍',textStyle:{color:legend_color}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 20
                }
            }
        },
        data:[
            {value:476, name:'户籍'},
            {value:376, name:'非户籍'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var label_option_hj_pie = chartPie(title_text,legend_data,series);
    label_ageBar.setOption(label_option_age_bar);
    label_sexPie.setOption(label_option_sex_pie);

    label_hjPie.setOption(label_option_hj_pie)
</script>

 <script>
        $(".selectLabel").css("height",winHeight/8.4);
        $("#label1").css("height",winHeight/5);
        $(".label3").css("height",winHeight/5);
     function picChange(index){
         for(var i=0;i<markerArr.length;i++){
             var json = markerArr[i];
             var p0 = json.point.split("|")[0];
             var p1 = json.point.split("|")[1];
             var point = new BMap.Point(p0,p1);
             var iconImg = createIcon(json.icon);
             var marker = new BMap.Marker(point,{icon:iconImg});
             var iw = createInfoWindow(i);
             var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
             marker.setLabel(label);
             map.addOverlay(marker);
             label.setStyle({
                 borderColor:"#808080",
                 color:"#333",
                 cursor:"pointer",
                 maxWidth:"none"
             });

             (function(){
                 var index = i;
                 var _iw = createInfoWindow(i);
                 var _marker = marker;
                 _marker.addEventListener("click",function(){
                     this.openInfoWindow(_iw);
                 });
                 _iw.addEventListener("open",function(){
                     _marker.getLabel().hide();
                 })
                 _iw.addEventListener("close",function(){
                     _marker.getLabel().show();
                 })
                 label.addEventListener("click",function(){
                     _marker.openInfoWindow(_iw);
                 })
                 if(!!json.isOpen){
                     label.hide();
                     _marker.openInfoWindow(_iw);
                 }
             })()
         }
         var allOverlay = map.getOverlays();
         var len = map.getOverlays().length;
         var str = null;
         if(index == 1) str="养老院";//老有所养
         else if(index == 2) str="社区卫生站";//所医
         else if(index == 3) str="助餐点";//所为
         else if(index == 4) str="老年人学校";//所学
         else if(index == 5) str="社区卫生站";//所乐
         for (var i = len; i >0; i--){
             if (allOverlay[i] instanceof BMap.Marker)
                 if(allOverlay[i].getLabel().content.indexOf(str) == -1)
                 {
                     map.removeOverlay(map.getOverlays()[i]);

                 }

         }

     }

     function showHeatMap(){
         document.getElementById("container").style.display="none";
         document.getElementById("dituContent").style.display="";
         // // $("#dituContent").empty();
         // // $("#dituContent").remove();
         // // $("#dituContent").css("width",winWidth/3.5);
         // // $("#dituContent").css("height",winHeight/1.55);
         //
         // //创建和初始化地图函数：
         // function initMap(){
         //     createMap();//创建地图
         //     setMapEvent();//设置地图事件
         //     addMapControl();//向地图添加控件
         //     addPolygon();//多边形覆盖物
         //     addPolyline();//向地图中添加线
         //     addMarker();//向地图中添加标注
         // }
         //
         // //创建地图函数：
         // function createMap(){
         //     var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
         //     var point = new BMap.Point(121.404295,31.151234);//定义一个中心点坐标
         //     map.centerAndZoom(point,16);//设定地图的中心点和坐标并将地图显示在地图容器中
         //     window.map = map;//将map变量存储在全局
         // }
         //
         // //地图事件设置函数：
         // function setMapEvent(){
         //     map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
         //     map.enableScrollWheelZoom();//启用地图滚轮放大缩小
         //     map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
         //     map.enableKeyboard();//启用键盘上下左右键移动地图
         // }
         //
         // //地图控件添加函数：
         // function addMapControl(){
         //     //向地图中添加缩放控件
         //     var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
         //     map.addControl(ctrl_nav);
         //     //向地图中添加缩略图控件
         //     var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
         //     map.addControl(ctrl_ove);
         //     //向地图中添加比例尺控件
         //     var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
         //     map.addControl(ctrl_sca);
         // }
         //
         // //标注点数组
         // //标注点数组
         // var markerArr = [{title:"养老院A",content:"养老院A",point:"121.385888|31.162065",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
         //     ,{title:"养老院B",content:"养老院B",point:"121.400297|31.162065",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
         //     ,{title:"养老院C",content:"养老院C",point:"121.409783|31.158419",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
         //     ,{title:"长者照护之家A",content:"长者照护之家A",point:"121.408562|31.166948",isOpen:0,icon:{w:21,h:21,l:6,t:0,x:6,lb:5}}
         //     ,{title:"长者照护之家B",content:"长者照护之家B",point:"121.409999|31.152424",isOpen:0,icon:{w:21,h:21,l:6,t:0,x:6,lb:5}}
         //     ,{title:"长者照护之家C",content:"长者照护之家C",point:"121.388008|31.157801",isOpen:0,icon:{w:21,h:21,l:6,t:0,x:6,lb:5}}
         //     ,{title:"日照中心A",content:"日照中心A",point:"121.388943|31.153227",isOpen:0,icon:{w:21,h:21,l:23,t:0,x:6,lb:5}}
         //     ,{title:"日照中心B",content:"日照中心B",point:"121.393973|31.161015",isOpen:0,icon:{w:21,h:21,l:23,t:0,x:6,lb:5}}
         //     ,{title:"日照中心C",content:"日照中心C",point:"121.396488|31.157739",isOpen:0,icon:{w:21,h:21,l:23,t:0,x:6,lb:5}}
         //     ,{title:"助餐点A",content:"助餐点A",point:"121.396776|31.153567",isOpen:0,icon:{w:21,h:21,l:69,t:0,x:6,lb:5}}
         //     ,{title:"助餐点B",content:"助餐点B",point:"121.38923|31.151064",isOpen:0,icon:{w:21,h:21,l:69,t:0,x:6,lb:5}}
         //     ,{title:"助餐点C",content:"助餐点C",point:"121.390021|31.141792",isOpen:0,icon:{w:21,h:21,l:69,t:0,x:6,lb:5}}
         //     ,{title:"社区卫生站A",content:"社区卫生站A",point:"121.389374|31.148221",isOpen:0,icon:{w:21,h:21,l:92,t:0,x:6,lb:5}}
         //     ,{title:"社区卫生站B",content:"社区卫生站B",point:"121.402022|31.147788",isOpen:0,icon:{w:21,h:21,l:92,t:0,x:6,lb:5}}
         //     ,{title:"老年人学校A",content:"老年人学校A",point:"121.394836|31.139258",isOpen:0,icon:{w:23,h:25,l:0,t:21,x:9,lb:12}}
         //     ,{title:"社区医院A",content:"社区医院A",point:"121.409927|31.146861",isOpen:0,icon:{w:23,h:25,l:46,t:21,x:9,lb:12}}
         // ];
         // //创建marker
         // function addMarker(){
         //     for(var i=0;i<markerArr.length;i++){
         //         var json = markerArr[i];
         //         var p0 = json.point.split("|")[0];
         //         var p1 = json.point.split("|")[1];
         //         var point = new BMap.Point(p0,p1);
         //         var iconImg = createIcon(json.icon);
         //         var marker = new BMap.Marker(point,{icon:iconImg});
         //         var iw = createInfoWindow(i);
         //         var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
         //         marker.setLabel(label);
         //         map.addOverlay(marker);
         //         label.setStyle({
         //             borderColor:"#808080",
         //             color:"#333",
         //             cursor:"pointer",
         //             maxWidth:"none"
         //         });
         //
         //         (function(){
         //             var index = i;
         //             var _iw = createInfoWindow(i);
         //             var _marker = marker;
         //             _marker.addEventListener("click",function(){
         //                 this.openInfoWindow(_iw);
         //             });
         //             _iw.addEventListener("open",function(){
         //                 _marker.getLabel().hide();
         //             })
         //             _iw.addEventListener("close",function(){
         //                 _marker.getLabel().show();
         //             })
         //             label.addEventListener("click",function(){
         //                 _marker.openInfoWindow(_iw);
         //             })
         //             if(!!json.isOpen){
         //                 label.hide();
         //                 _marker.openInfoWindow(_iw);
         //             }
         //         })()
         //     }
         // }
         // //创建InfoWindow
         // function createInfoWindow(i){
         //     var json = markerArr[i];
         //     var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
         //     return iw;
         // }
         // //创建一个Icon
         // function createIcon(json){
         //     var icon = new BMap.Icon("http://map.baidu.com/image/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
         //
         //     //var icon = new BMap.Icon("http://app.baidu.com/map/image/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
         //     return icon;
         // }
         // //标注线数组
         // var plPoints = [{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.383679|31.163464","121.388709|31.162908","121.391404|31.162629","121.393812|31.162908","121.397315|31.164043"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.397333|31.164051","121.401106|31.16538","121.405418|31.166554","121.409226|31.168099","121.414437|31.155275","121.416296|31.150832"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.416305|31.150917","121.415874|31.15067","121.415694|31.150516","121.416233|31.149063","121.416413|31.14829","121.416089|31.147672","121.414796|31.146436","121.410664|31.144674","121.408939|31.143593","121.406738|31.149844","121.408104|31.145826"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.406882|31.149967","121.402723|31.147301","121.397944|31.146096","121.399848|31.138771","121.399776|31.138957"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.399848|31.13874","121.400746|31.135247","121.399848|31.135155","121.396255|31.134196","121.396345|31.134212"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.396381|31.134227","121.391961|31.13313"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.391907|31.133161","121.390075|31.136499","121.38844|31.139636","121.388458|31.139636"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.388422|31.139621","121.388206|31.140332","121.388026|31.143206","121.387119|31.153243"]}
         //     ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.387191|31.152996","121.385538|31.159547","121.383454|31.163379","121.383382|31.163503"]}
         // ];
         // //向地图中添加线函数
         // function addPolyline(){
         //     for(var i=0;i<plPoints.length;i++){
         //         var json = plPoints[i];
         //         var points = [];
         //         for(var j=0;j<json.points.length;j++){
         //             var p1 = json.points[j].split("|")[0];
         //             var p2 = json.points[j].split("|")[1];
         //             points.push(new BMap.Point(p1,p2));
         //         }
         //         var line = new BMap.Polyline(points,{strokeStyle:json.style,strokeWeight:json.weight,strokeColor:json.color,strokeOpacity:json.opacity});
         //         map.addOverlay(line);
         //     }
         // }
         // //添加多边形
         // function addPolygon(){
         //     var polygon1 = new BMap.Polygon([
         //         new BMap.Point(121.383679, 31.163464),
         //         new BMap.Point(121.388709, 31.162908),
         //         new BMap.Point(121.391404, 31.162629),
         //         new BMap.Point(121.393812, 31.162908),
         //
         //         new BMap.Point(121.397315, 31.164043),
         //         new BMap.Point(121.397333, 31.164051),
         //         new BMap.Point(121.401106, 31.16538),
         //         new BMap.Point(121.405418, 31.166554),
         //         new BMap.Point(121.409226, 31.168099),
         //         new BMap.Point(121.414437, 31.155275),
         //         new BMap.Point(121.416296, 31.150832),
         //         new BMap.Point(121.416305, 31.150917),
         //
         //         new BMap.Point(121.415874, 31.15067),
         //         new BMap.Point(121.415694, 31.150516),
         //         new BMap.Point(121.416233, 31.149063),
         //         new BMap.Point(121.416413, 31.14829),
         //         new BMap.Point(121.416089, 31.147672),
         //         new BMap.Point(121.414796, 31.146436),
         //         new BMap.Point(121.410664, 31.144674),
         //         new BMap.Point(121.408939, 31.143593),
         //         new BMap.Point(121.406738, 31.149844),
         //         new BMap.Point(121.408104, 31.145826),
         //         new BMap.Point(121.406882, 31.149967),
         //         new BMap.Point(121.402723, 31.147301),
         //         new BMap.Point(121.397944, 31.146096),
         //         new BMap.Point(121.399848, 31.138771),
         //
         //         new BMap.Point(121.399776, 31.138957),
         //         new BMap.Point(121.399848, 31.13874),
         //         new BMap.Point(121.400746, 31.135247),
         //         new BMap.Point(121.399848, 31.135155),
         //         new BMap.Point(121.396255, 31.134196),
         //         new BMap.Point(121.396345, 31.134212),
         //         new BMap.Point(121.396381, 31.134227),
         //         new BMap.Point(121.391961, 31.13313),
         //         new BMap.Point(121.391907, 31.133161),
         //         new BMap.Point(121.390075, 31.136499),
         //         new BMap.Point(121.38844, 31.139636),
         //         new BMap.Point(121.388458, 31.139636),
         //         new BMap.Point(121.388422, 31.139621),
         //         new BMap.Point(121.388206, 31.140332),
         //         new BMap.Point(121.388026, 31.143206),
         //         new BMap.Point(121.387119, 31.153243),
         //
         //         new BMap.Point(121.387191, 31.152996),
         //         new BMap.Point(121.385538, 31.159547),
         //         new BMap.Point(121.383454, 31.163379),
         //         new BMap.Point(121.383382, 31.163503)
         //
         //
         //     ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#FFFFFF" });
         //     map.addOverlay(polygon1);
         //     //
         // }
         // function getRandomColor() {
         //     //return "#" + ("00000" + ((Math.random() * 16777215 + 0.5) >> 0).toString(16)).slice(-6);
         //     return "#FFFFFF";
         // }
         //
         // initMap();//创建和初始化地图
         // map.setMapStyle({style:'midnight'});


     }

     function label3Show(index) {

         $("#label1").hide();
//         $(".aa").css("display","none");
//         $("#label").show();
         $("#label"+index).show();

     }

     function butt() {
         $('.select').each(function() {
             var cl=$(this).attr('class').split(' ')[1];
             $(this).attr('class','label '+cl);
         });$('#selectLabel').html('');ageBar = echarts.init(document.getElementById('ageBar'));
         sexPie= echarts.init(document.getElementById('sexPie'));
         pqBar= echarts.init(document.getElementById('pqBar'));
         hjPie= echarts.init(document.getElementById('hjPie'));
         ageBar.setOption(option_age_bar);
         sexPie.setOption(option_sex_pie);
         pqBar.setOption(option_pq_bar);
         hjPie.setOption(option_hj_pie);
     }

     var la=[];
     $("span.label").click(
             function () {
                 if($(this).attr("class").indexOf("select")>0){
                     var cl=$(this).attr("class").split(" ")[1];
                     $(this).attr("class","label "+cl);
                     var laa=$(this).text().trim();
                     $("#selectLabel span").each(function () {
                         if($(this).text().trim()==laa){
                             $(".label3").hide();
                             $("#label1").show();

                             $(this).remove();
                             ageBar = echarts.init(document.getElementById('ageBar'));
                             sexPie= echarts.init(document.getElementById('sexPie'));
                             pqBar= echarts.init(document.getElementById('pqBar'));
                             hjPie= echarts.init(document.getElementById('hjPie'));
                             ageBar.setOption(option_age_bar);
                             sexPie.setOption(option_sex_pie);
                             pqBar.setOption(option_pq_bar);
                             hjPie.setOption(option_hj_pie);


                             return;
                         }
                     });
                 }else {

                     $(this).addClass("select");
                     var text = $(this).text();
                     var cl=$(this).attr("class").split(" ")[1];
                     $("#selectLabel").append($("<span class='bl label "+cl+"'>" + text + "</span>"));
                     la.push(text);
//             table.fnFilter();
                     $(".label3").hide();
                     $("#label1").show();

                     ageBar = echarts.init(document.getElementById('ageBar'));
                     sexPie = echarts.init(document.getElementById('sexPie'));
                     pqBar = echarts.init(document.getElementById('pqBar'));
                     hjPie = echarts.init(document.getElementById('hjPie'));
                     ageBar.setOption(option_age_bar);
                     sexPie.setOption(option_sex_pie);
                     pqBar.setOption(option_pq_bar);
                     hjPie.setOption(option_hj_pie);
                 }
             }
     );
 </script>
