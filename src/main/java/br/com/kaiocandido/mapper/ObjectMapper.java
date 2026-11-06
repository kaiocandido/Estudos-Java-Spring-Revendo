package br.com.kaiocandido.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){

        List<D> destinationOrderObjects = new ArrayList<D>();

        for (Object o : origin){
           destinationOrderObjects.add(mapper.map(o, destination));
        }

        return destinationOrderObjects;
    }

}
