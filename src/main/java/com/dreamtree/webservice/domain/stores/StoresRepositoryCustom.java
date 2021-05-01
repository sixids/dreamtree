package com.dreamtree.webservice.domain.stores;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.util.StringUtils;

import java.util.List;

public interface StoresRepositoryCustom {

    List<Stores> getStoresDynamicQuery(double bottom, double left, double top, double right, String name, String card);

    BooleanExpression isInnerLat(double bottom, double top);
    BooleanExpression isInnerLng(double left, double right);
    BooleanExpression containsName(String name);
    BooleanExpression eqCard(String card);

}
