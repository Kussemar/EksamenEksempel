package dk.lyngby.dao.impl;

import dk.lyngby.dao.IDao;
import dk.lyngby.dto.PlantDTO;
import dk.lyngby.dto.ResellerDTO;

import java.util.ArrayList;
import java.util.List;

public class ResellerDAOGeneric implements IDao<ResellerDTO, Integer> {

    private static List<ResellerDTO> mockDB = new ArrayList<>();

    @Override
    public ResellerDTO read(Integer id) {
        return mockDB.stream().filter(reseller -> reseller.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<ResellerDTO> readAll() {
        return mockDB;
    }

    @Override
    public ResellerDTO create(ResellerDTO reseller) {
        mockDB.add(reseller);
        return reseller;
    }

    @Override
    public ResellerDTO update(Integer id, ResellerDTO reseller) {
        for (int i = 0; i < mockDB.size(); i++) {
            if (mockDB.get(i).getId() == id) {
                mockDB.set(i, reseller);
                return reseller;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        mockDB.removeIf(reseller -> reseller.getId() == id);
    }

    @Override
    public boolean validatePrimaryKey(Integer id) {
        return mockDB.stream().anyMatch(reseller -> reseller.getId() == id);
    }
}