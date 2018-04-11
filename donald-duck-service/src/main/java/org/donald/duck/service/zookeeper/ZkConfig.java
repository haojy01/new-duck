package org.donald.duck.service.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkConfig {

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

		ZookeeperConnection zk = new ZookeeperConnection();

		final ZooKeeper connect = zk.connect("localhost");

		if (connect == null) {
			return;
		} else {
			connect.register(new Watcher() {
				@Override
				public void process(WatchedEvent watchedevent) {
					System.out.println(watchedevent.getPath() + watchedevent.getType());
					try {
						connect.getData("/config", true, null);
					} catch (KeeperException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			});
			Stat exists = connect.exists("/config", true);
			if (exists == null) {
				System.out.println("配置不存在");
				connect.create("/config", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			connect.getData("/config", true, null);

		}

		while (true) {

		}
	}
}
