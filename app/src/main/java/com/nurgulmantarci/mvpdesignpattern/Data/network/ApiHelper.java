package com.nurgulmantarci.mvpdesignpattern.Data.network;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CategoryService;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CommandService;

public interface ApiHelper extends CommandService, CategoryService {
   //Servisleri kendi aralarında daha rahat kontrol etmek için parçaladığımız yer.

}
