package com.thlogistic.route.core.usecases;

import com.thlogistic.route.core.entities.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
interface ListLocationUseCase extends BaseUseCase<String, List<Location>> {
}
