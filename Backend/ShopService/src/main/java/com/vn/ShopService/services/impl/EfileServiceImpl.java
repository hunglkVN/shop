package com.vn.ShopService.services.impl;

import com.vn.ShopService.entities.Efile;
import com.vn.ShopService.repositories.EfileRepository;
import com.vn.ShopService.services.EfileService;
import com.vn.ShopService.utils.DateUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EfileServiceImpl implements EfileService {

    final EfileRepository efileRepository;

//    @Scheduled(initialDelay = 10, fixedDelay=Long.MAX_VALUE)
    @Override
    public void insertData() throws CloneNotSupportedException {
        Efile efile1 = efileRepository.findByCode("NK_2024_000086");
        final Efile[] efile = {(Efile) efile1.clone()};
//        if (efile != null) {
//            int i = 0;
//            while (i < 500000) {
//                efile.setId(null);
//                efile.setCode(generateCodeNew(efile));
//                efile.setCreateTime(DateUtils.addDay(efile.getCreateTime(), 1));
//                efile = (Efile) efileRepository.save(efile).clone();
//                System.out.println("saved " + i + ": " + efile.getCode());
//                i++;
//            }
//        }

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arr.add(i);
        }
        arr.parallelStream().forEach(a -> {
            efile[0].setId(null);
            efile[0].setCode(generateCodeNew(efile[0]));
            efile[0].setCreateTime(DateUtils.addDay(efile[0].getCreateTime(), 1));
            try {
                efile[0] = (Efile) efileRepository.save(efile[0]).clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("saved " + a + ": " + efile[0].getCode());
        });

    }

    private String generateCodeNew(Efile efile) {
        Integer max = efileRepository.countAllNotDelete();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("YYYY");
        String format = simpleDateFormat.format(date);
        return (efile.getProcedureCode().equals("PT7") ? "NK" : "TN") + "_" + format + "_" + String.format("%06d", max + 1);
    }
}
