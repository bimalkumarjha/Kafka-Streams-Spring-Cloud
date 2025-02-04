package bimal.learning.examples.kafka.advertclicks.bindings;

import bimal.learning.examples.kafka.advertclicks.models.AdClick;
import bimal.learning.examples.kafka.advertclicks.models.AdInventories;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface ClicksListenerBinding {

    @Input("inventories-channel")
    GlobalKTable<String, AdInventories> inventoryInputStream();

    @Input("clicks-channel")
    KStream<String, AdClick> clickInputStream();

}
