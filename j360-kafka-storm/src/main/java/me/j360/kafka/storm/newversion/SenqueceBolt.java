package me.j360.kafka.storm.newversion;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: me.j360.kafka.storm
 * User: min_xu
 * Date: 16/7/22 下午2:05
 * 说明：
 */
public class SenqueceBolt extends BaseBasicBolt {

    static Logger logger = LoggerFactory.getLogger(SenqueceBolt.class);

    /* (non-Javadoc)
     * @see backtype.storm.topology.IBasicBolt#execute(backtype.storm.tuple.Tuple, backtype.storm.topology.BasicOutputCollector)
     */
    public void execute(Tuple input, BasicOutputCollector collector) {
        // TODO Auto-generated method stub
        String word = (String) input.getValue(0);
        String out = "I'm " + word +  "!";

        logger.debug(out);
        collector.emit(new Values(out));
    }

    /* (non-Javadoc)
     * @see backtype.storm.topology.IComponent#declareOutputFields(backtype.storm.topology.OutputFieldsDeclarer)
     */
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("message"));
    }
}
