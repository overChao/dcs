package com.crodi.base.sevice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crodi.base.ContainerApi;
import com.crodi.mapper.ContainerMapper;
import com.crodi.model.Container;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/7/29 9:57
 * @Description: TODO
 **/

@Service
@RequiredArgsConstructor
public class ContainerService implements ContainerApi {

    private final ContainerMapper containerMapper;

    @Override
    public void saveContainer(Container container) {
        containerMapper.insert(container);
    }

    @Override
    public void deleteContainer(Container container) {
        Wrapper<Container> wrapper = new LambdaQueryWrapper<Container>()
                .eq(Container::getContainerCode, container.getContainerCode())
                .eq(Container::getDeleted, false)
                .eq(Container::getActive, true);
        containerMapper.update(container, wrapper);
    }

    @Override
    public void updateContainer(Container container) {
        Wrapper<Container> wrapper = new LambdaQueryWrapper<Container>()
                .eq(Container::getContainerCode, container.getContainerCode())
                .eq(Container::getDeleted, false)
                .eq(Container::getActive, true);
        containerMapper.update(container, wrapper);
    }

    @Override
    public Container getContainer(String nodeCode) {
        Wrapper<Container> wrapper = new LambdaQueryWrapper<Container>()
                .eq(Container::getNodeCode, nodeCode)
                .eq(Container::getDeleted, false)
                .eq(Container::getActive, true);
        return containerMapper.selectOne(wrapper);

    }

    @Override
    public List<Container> getAllContainers(String mapCode) {
        Wrapper<Container> wrapper = new LambdaQueryWrapper<Container>()
                .eq(Container::getMapCode, mapCode)
                .eq(Container::getDeleted, false)
                .eq(Container::getActive, true);
        return containerMapper.selectList(wrapper);
    }
}
