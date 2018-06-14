package com.organOld.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 可视化
 * Created by netlab606 on 2018/4/8.
 */
@Controller
@RequestMapping("/visual")
public class VisualController {

    @RequestMapping(value ="/new/one",method = RequestMethod.GET)
    public ModelAndView one(){
        return new ModelAndView("visual/new/one");
    }

    @RequestMapping(value = "/new/two1" ,method = RequestMethod.GET)
    public ModelAndView two1(){
        return new ModelAndView("visual/new/two_1");
    }
    @RequestMapping(value = "/new/two2" ,method = RequestMethod.GET)
    public ModelAndView two2(){
        return new ModelAndView("visual/new/two_2");
    }
    @RequestMapping(value = "/new/two3" ,method = RequestMethod.GET)
    public ModelAndView two3(){
        return new ModelAndView("visual/new/two_3");
    }
    @RequestMapping(value = "/new/two4" ,method = RequestMethod.GET)
    public ModelAndView two4(){
        return new ModelAndView("visual/new/two_4");
    }
    @RequestMapping(value = "/new/two5" ,method = RequestMethod.GET)
    public ModelAndView two5(){
        return new ModelAndView("visual/new/two_5");
    }
    @RequestMapping(value = "/new/three1" ,method = RequestMethod.GET)
    public ModelAndView three1(){
        return new ModelAndView("visual/new/three_1");
    }
    @RequestMapping(value = "/new/three2" ,method = RequestMethod.GET)
    public ModelAndView three2(){
        return new ModelAndView("visual/new/three_2");
    }
    @RequestMapping(value = "/new/three3" ,method = RequestMethod.GET)
    public ModelAndView three3(){
        return new ModelAndView("visual/new/three_3");
    }
    @RequestMapping(value = "/new/four" ,method = RequestMethod.GET)
    public ModelAndView four(){
        return new ModelAndView("visual/new/four");
    }
    @RequestMapping(value = "/new/five" ,method = RequestMethod.GET)
    public ModelAndView five(){
        return new ModelAndView("visual/new/five");
    }
    @RequestMapping(value = "/new/five1" ,method = RequestMethod.GET)
    public ModelAndView five1(){
        return new ModelAndView("visual/new/five_1");
    }
    @RequestMapping(value = "/new/five2" ,method = RequestMethod.GET)
    public ModelAndView five2(){
        return new ModelAndView("visual/new/five_2");
    }
    @RequestMapping(value = "/new/three11" ,method = RequestMethod.GET)
    public ModelAndView three11(){
        return new ModelAndView("visual/new/three_1_1");
    }
    @RequestMapping(value = "/new/three12" ,method = RequestMethod.GET)
    public ModelAndView three12(){
        return new ModelAndView("visual/new/three_1_2");
    }
    @RequestMapping(value = "/new/three13" ,method = RequestMethod.GET)
    public ModelAndView three13(){
        return new ModelAndView("visual/new/three_1_2_zz");
    }
    @RequestMapping(value = "/new/three14" ,method = RequestMethod.GET)
    public ModelAndView three14(){
        return new ModelAndView("visual/new/three_1_2_zc");
    }
    @RequestMapping(value = "/new/three15" ,method = RequestMethod.GET)
    public ModelAndView three15(){
        return new ModelAndView("visual/new/three_1_2_rz");
    }
    @RequestMapping(value = "/new/three16" ,method = RequestMethod.GET)
    public ModelAndView three16(){
        return new ModelAndView("visual/new/three_1_3");
    }
    @RequestMapping(value = "/new/threesum" ,method = RequestMethod.GET)
    public ModelAndView threesum(){
        return new ModelAndView("visual/new/three_sum");
    }
    @RequestMapping(value = "/new/twosum" ,method = RequestMethod.GET)
    public ModelAndView twosum(){
        return new ModelAndView("visual/new/two_sum");
    }
    @RequestMapping(value = "/new/map1" ,method = RequestMethod.GET)
    public ModelAndView map1(){
        return new ModelAndView("visual/new/map_1");
    }
    @RequestMapping(value = "/new/map2" ,method = RequestMethod.GET)
    public ModelAndView map2(){
        return new ModelAndView("visual/new/map_2");
    }
    /**
     * 老人汇总
     * @return
     */
    @RequestMapping(value = "" +
            "/split/oldman1",method = RequestMethod.GET)
    public ModelAndView on(){
        return new ModelAndView("visual/new/one");
    }

    @RequestMapping(value = "" +
            "/split/oldman2",method = RequestMethod.GET)
    public ModelAndView oldman2(){
        return new ModelAndView("visual/split/oldman_2");
    }

    @RequestMapping(value = "" +
            "/split/lookOldman1",method = RequestMethod.GET)
    public ModelAndView lookOldman1(){
        return new ModelAndView("visual/split/look_oldman_1");
    }
    @RequestMapping(value = "" +
            "/split/lookOldman2",method = RequestMethod.GET)
    public ModelAndView lookOldman2(){
        return new ModelAndView("visual/split/look_oldman_2");
    }
    @RequestMapping(value = "" +
            "/split/lookOldman3",method = RequestMethod.GET)
    public ModelAndView lookOldman3(){
        return new ModelAndView("visual/split/look_oldman_3");
    }
    @RequestMapping(value = "" +
            "/split/organJg",method = RequestMethod.GET)
    public ModelAndView organjg(){
        return new ModelAndView("visual/split/organ_jg");
    }
    @RequestMapping(value = "" +
            "/split/organJs",method = RequestMethod.GET)
    public ModelAndView organjs1(){
        return new ModelAndView("visual/split/organ_js");
    }



    @RequestMapping(value = "/oldman",method = RequestMethod.GET)
    public ModelAndView oldma(){
        return new ModelAndView("visual/oldman");
    }
    /**
     * 标签
     * @return
     */
    @RequestMapping(value = "/label",method = RequestMethod.GET)
    public ModelAndView label(){
        return new ModelAndView("visual/label");
    }

    @RequestMapping(value = "/lookOldman",method = RequestMethod.GET)
    public ModelAndView look_oldman(){
        return new ModelAndView("visual/look_oldman");
    }
}
