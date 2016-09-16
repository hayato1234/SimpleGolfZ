package com.smileman.toshiba.simplegolfz;

import java.util.ArrayList;

/**
 * Created by toshiba on 2016/04/29.
 */
public class CourseInfo extends ArrayList<Course> {

    public CourseInfo(){
        add(new Course(0, R.drawable.foster, "Foster","http://www.fostergolflinks.com/-scorecard","http://www.fostergolflinks.com/-rates","http://www.fostergolflinks.com/",true,"Driving Range: NO","Other Info: FootGolf"  ));
        add(new Course(1, R.drawable.interbay, "Interbay Golf Course","http://premiergc.com/-course(4)","http://premiergc.com/-rates(2)","http://premiergc.com/-hours(2)",false,"Driving Range: Yes","Other Info: Miniature Golf, Club Fitting" ));
        add(new Course(2, R.drawable.jacson_park, "Jackson Park" ,"http://premiergc.com/-course","http://premiergc.com/-rates(4)","http://premiergc.com/-hours(3)",true,"Driving Range: Yes","Other Info: Cafe" ));
        add(new Course(3, R.drawable.jacson_park, "Jackson Park 9 Hole Course" ,"http://premiergc.com/-course","http://premiergc.com/-rates(4)","http://premiergc.com/-hours(3)",false,"Driving Range: Yes","Other Info: Cafe" ));
        add(new Course(4, R.drawable.jefferson, "Jefferson Park","http://premiergc.com/-course(2)","http://premiergc.com/-rates(5)","http://premiergc.com/-hours(4)",true  ,"Driving Range: Yes","Other Info: Beacon Grill Restaurant (Including: Full bar, outdoor seating & express window)" ));
        add(new Course(5, R.drawable.jeffersonshort, "Jefferson Park 9 Hole","http://premiergc.com/-course(2)","http://premiergc.com/-rates(5)","http://premiergc.com/-hours(4)",false ,"Driving Range: Yes","Other Info: Beacon Grill Restaurant (Including: Full bar, outdoor seating & express window)"  ));
        add(new Course(6, R.drawable.lynnwood, "Lynnwood","http://www.lynnwoodgc.com/-course","http://www.lynnwoodgc.com/-rates","http://www.lynnwoodgc.com/-hours", true ,"Driving Range: No","Other Info: Non"  ));
        add(new Course(7, R.drawable.riverbend, "Riverbend 18-Hole" ,"http://www.riverbendgolfcomplex.com/Course/layout/","http://www.riverbendgolfcomplex.com/Course/rates/","http://www.riverbendgolfcomplex.com/course/",true,"Driving Range: Yes","Other Info: Miniature Golf" ));
        add(new Course(8, R.drawable.riverbendshort, "Riverbend Par 3" ,"http://www.riverbendgolfcomplex.com/par3-course/","http://www.riverbendgolfcomplex.com/par3-course/rates_37/","http://www.riverbendgolfcomplex.com/par3-course/",false,"Driving Range: Yes","Other Info: Miniature Golf" ));
        add(new Course(9, R.drawable.westeattle, "West Seattle" ,"http://premiergc.com/-course(3)","http://premiergc.com/-rates(3)","http://premiergc.com/-hours",true,"Driving Range: No","Other Info: Restaurant" ));
        add(new Course(10, R.drawable.willowsrun, "Willows Run (Eagle’s Talon)","http://willowsrun.com/course/eagles-talon/","http://willowsrun.com/courses/?section=rates","http://willowsrun.com/courses/?section=rates",true,"Driving Range: Yes","Other Info: Trail"   ));
        add(new Course(11, R.drawable.willows_run_coyote_creek, "Willows Run (Coyote Creek)","http://willowsrun.com/course/coyote-creek/","http://willowsrun.com/courses/?section=rates","http://willowsrun.com/courses/?section=rates",true,"Driving Range: Yes","Other Info: Trail"));
        add(new Course(12, R.drawable.willowsrun, "Willows Run Heron Links","http://willowsrun.com/course/heron-links/","http://willowsrun.com/courses/?section=rates","http://willowsrun.com/courses/?section=rates",false,"Driving Range: Yes","Other Info: Trail"));
    }
}
