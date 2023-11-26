import { useContract, useContractMetadata } from '@thirdweb-dev/react'
import HeroCard from '../../components/HeroCard'
import styles from '../../styles/Home.module.css'
import { ERC20_CONTRACT_ADDRESS } from '../../constants/addresses'
const Erc20 = () => {
    const {contract}=useContract(ERC20_CONTRACT_ADDRESS,"token")
    const {data:contractMetadata,isLoading:contractMetadataIsLoading}=useContractMetadata(contract)
  return (
    <div className={styles.container}>
        <HeroCard 
            isLoading={contractMetadataIsLoading}
            title={contractMetadata?.name!}
            description={contractMetadata?.description!}
            image={contractMetadata?.image!}
        />
    </div>
  )
}

export default Erc20