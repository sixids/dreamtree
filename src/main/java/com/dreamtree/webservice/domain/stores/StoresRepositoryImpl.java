package com.dreamtree.webservice.domain.stores;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.dreamtree.webservice.domain.stores.QStores.stores;

import java.util.List;

@RequiredArgsConstructor
public class StoresRepositoryImpl implements StoresRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<Stores> getStoresDynamicQuery(double bottom, double left, double top, double right, String name, String card) {
        return queryFactory
                .selectFrom(stores)
                .where(isInnerLat(bottom, top),
                        isInnerLng(left, right),
                        containsName(name),
                        eqCard(card)
                )
                .fetch();
    }

    @Override
    public BooleanExpression isInnerLat(double bottom, double top) {
        return stores.lat.between(bottom, top);
    }

    @Override
    public BooleanExpression isInnerLng(double left, double right) {
        return stores.lng.between(left, right);
    }

    @Override
    public BooleanExpression containsName(String name) {
        if (!StringUtils.hasText(name)) {
            return null;
        }
        return stores.name.contains(name);
    }

    @Override
    public BooleanExpression eqCard(String card) {
        if (!StringUtils.hasText(card)){
            return null;
        }
        return stores.card.eq(card);
    }

}
