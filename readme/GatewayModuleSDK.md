# GatewayModuleSDK.java
SDK 接口

## GatewayModuleSDK
| Return <br/> 返回 | Method <br/> 方法 |
| - | - |
| void | <br/> `setObserver`([GatewayModuleSDK.Observer](#GatewayModuleSDK.Observer) observer) <br/><br/> 设置回调监听者 <br/> observer: 监听者  |
| void | <br/> `setSerialPort` (String serialPort) <br/><br/> Set Serial Port <br/> serialPort: Serial Port <br/><br/> 设置串口Port <br/> serialPort: 串口路径 |
| List<[PeripheralInfo](define/PeripheralInfo.md)> | <br/> `getPeripheralList` () <br/><br/> Get Peripheral List <br/><br/> 获取分机列表 |

## GatewayModuleSDK.Observer
| Return <br/> 返回 | Method <br/> 方法 |
| - | - |
| void | <br/> `onPeripheralStateChange`(Byte peripheralId) <br/><br/> On Peripheral State Change <br/> peripheralId: Peripheral ID <br/><br/> 当分机状态改变 <br/> peripheralId: 分机ID |
| void | <br/> `onPeripheralListChange`() <br/><br/> On Peripheral List Change <br/><br/> 当分机列表发生改变 |
