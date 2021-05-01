package com.dreamtree.webservice.domain.stores;

import com.dreamtree.webservice.domain.stores.QStores;
import com.dreamtree.webservice.domain.stores.Stores;
import com.dreamtree.webservice.domain.stores.StoresRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoresRepositoryTest {

    @Autowired
    StoresRepository storesRepository;

    @Before
    public void cleanUp() {
        storesRepository.deleteAll();

        storesRepository.save(Stores.builder()
                .card("test")
                .name("test")
                .store_type("test")
                .lat(123.123456)
                .lng(1.234567)
                .build()
        );
    }

    @Test
    public void getAll_확인 () {
        //when
        List<Stores> storesList = storesRepository.findAll();

        //then
        Stores stores = storesList.get(0);
        assertThat(stores.getCard(), is("test"));
        assertThat(stores.getName(), is("test"));
        assertThat(stores.getStore_type(), is("test"));
        assertThat(stores.getLat(), is(123.123456));
    }

    @Test
    public void 이름찾기() {
        //when
        List<Stores> storesList = storesRepository.getStoresDynamicQuery(0,0,200,200 ,"t","test");

        //then
        Stores stores = storesList.get(0);

        assertThat(stores.getCard(), is("test"));
        assertThat(stores.getName(), is("test"));
        assertThat(stores.getStore_type(), is("test"));
        assertThat(stores.getLat(), is(123.123456));
    }
}
